// bidingsystem.component.ts
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WebsocketService } from '../../services/websocket.service';
import { HttpClient } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { BidskeletonComponent } from '../bidskeleton/bidskeleton.component';

@Component({
  selector: 'app-bidingsystem',
  standalone: true,
  imports: [CommonModule, FormsModule,BidskeletonComponent],
  templateUrl: './bidingsystem.component.html',
  styleUrls: ['./bidingsystem.component.scss']
})
export class BidingsystemComponent implements OnInit, OnDestroy {
  property: any;
  bidAmount: number | null = null;
  currentBid: number = 0;
  bids: any[] = [];
   isLoadingBids = true;
  private bidSubscription!: Subscription;
  private propertyId!: number;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private websocketService: WebsocketService,
    private http: HttpClient
  ) {
    const navigation = this.router.getCurrentNavigation();
    this.property = navigation?.extras?.state?.['propertyData'];
    
    if (this.property) {
      this.propertyId = this.property.id;
      this.currentBid = this.property.currentBid;
      this.bids = this.property.bids || [];
    }
    this.http.get<any[]>(`http://localhost:8080/api/bids/property/${this.propertyId}`).subscribe(data => {
      this.bids = data;
      this.isLoadingBids = false;
    });
  }

  async ngOnInit() {
  if (!this.property) {
    this.router.navigate(['/']);
    return;
  }

  try {
    // Wait for connection first
    await this.websocketService.connect();
    
    // Verify connection before subscribing
    this.bidSubscription = this.websocketService
      .subscribeToPropertyBids(this.propertyId)
      .subscribe({
        next: (bid) => {
          console.log('NEW BID RECEIVED:', bid); // Add this
          this.handleNewBid(bid);
        },
        error: (err) => console.error('Subscription error:', err)
      });
  } catch (error) {
    console.error('WebSocket connection failed:', error);
    alert('Realtime updates unavailable');
  }
}

  private handleNewBid(bid: any) {
    this.bids = [bid, ...this.bids];
    this.currentBid = bid.amount;
    
    // Auto-scroll to top of bid list
    const bidList = document.querySelector('.bid-history');
    if (bidList) bidList.scrollTop = 0;
  }

  getRemainingTime(endDateStr: string): string {
    if (!endDateStr) return 'N/A';
    const endDate = new Date(endDateStr);
    const now = new Date();
    const diff = endDate.getTime() - now.getTime();
    
    if (diff <= 0) return 'Expired';
    
    const days = Math.floor(diff / (1000 * 60 * 60 * 24));
    const hours = Math.floor((diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60));
    
    return `${days}d ${hours}h ${minutes}m`;
  }

  submitBid() {
    if (!this.validateBid()) return;

    const newBid = {
      propertyId: this.propertyId,
      amount: this.bidAmount!,
      userId: this.getCurrentUserId(), // Implement proper auth
      timestamp: new Date().toISOString()
    };

    this.websocketService.sendBid(newBid);
    this.bidAmount = null;
  }

  private validateBid(): boolean {
    if (!this.bidAmount) {
      alert('Please enter a bid amount');
      return false;
    }
    if (this.bidAmount <= this.currentBid) {
      alert(`Bid must be higher than current $${this.currentBid}`);
      return false;
    }
    return true;
  }

  private getCurrentUserId(): number {
    // Replace with actual user ID from authentication service
    return 2; // Temporary example
  }

  ngOnDestroy() {
    this.bidSubscription?.unsubscribe();
    // this.websocketService.disconnect();
  }
}