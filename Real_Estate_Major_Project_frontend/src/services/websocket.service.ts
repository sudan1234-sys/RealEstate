// websocket.service.ts
import { Injectable } from '@angular/core';
import { Client, IMessage } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { Subject, Observable, BehaviorSubject } from 'rxjs';

export interface Bid {
  propertyId: number;
  amount: number;
  userId: number;
  timestamp?: string;
}

@Injectable({ providedIn: 'root' })
export class WebsocketService {
  private stompClient!: Client;
  private bidSubjects: { [propertyId: number]: Subject<Bid> } = {};
  private connectionStatus = new BehaviorSubject<boolean>(false);
  private connectionPromise: Promise<void> | null = null;

  constructor() {
    this.initializeClient();
  }

  private initializeClient(): void {
    const socket = new SockJS('http://localhost:8080/ws-bid');
    
    this.stompClient = new Client({
      webSocketFactory: () => socket as any,
      debug: (str) => console.debug(str),
      reconnectDelay: 5000,
      heartbeatIncoming: 4000,
      heartbeatOutgoing: 4000
    });

    this.stompClient.onConnect = (frame) => {
      console.log('Successfully connected to WS');
      this.connectionStatus.next(true);
    };

    this.stompClient.onStompError = (frame) => {
      console.error('STOMP error:', frame.headers['message'], frame.body);
      this.connectionStatus.next(false);
    };

    this.stompClient.onWebSocketClose = () => {
      console.log('WebSocket connection closed');
      this.connectionStatus.next(false);
    };
  }

  connect(): Promise<void> {
    if (!this.connectionPromise) {
      this.connectionPromise = new Promise((resolve, reject) => {
        if (this.stompClient.connected) {
          resolve();
          return;
        }

        this.stompClient.activate();
        
        const checkConnected = () => {
          if (this.stompClient.connected) {
            resolve();
          } else {
            setTimeout(checkConnected, 100);
          }
        };

        setTimeout(() => {
          if (!this.stompClient.connected) {
            reject('Connection timeout');
          }
        }, 5000);

        checkConnected();
      });
    }
    return this.connectionPromise;
  }

  subscribeToPropertyBids(propertyId: number): Observable<Bid> {
    if (!this.bidSubjects[propertyId]) {
      this.bidSubjects[propertyId] = new Subject<Bid>();
      
      this.connect().then(() => {
        this.stompClient.subscribe(
          `/topic/bids/${propertyId}`,
          (message: IMessage) => {
            try {
              const bid: Bid = JSON.parse(message.body);
              this.bidSubjects[propertyId].next(bid);
            } catch (error) {
              console.error('Error parsing bid:', error);
            }
          }
        );
      }).catch(error => {
        console.error('Failed to subscribe:', error);
      });
    }
    return this.bidSubjects[propertyId].asObservable();
  }

  sendBid(bid: Bid): void {
    this.connect().then(() => {
      this.stompClient.publish({
        destination: '/app/placeBid',
        body: JSON.stringify(bid)
      });
      console.log('Bid successfully sent:', bid);
    }).catch(error => {
      console.error('Failed to send bid:', error);
    });
  }

  disconnect(): void {
    if (this.stompClient?.connected) {
      this.stompClient.deactivate();
      this.connectionPromise = null;
      console.log('Disconnected from WebSocket');
    }
  }
}