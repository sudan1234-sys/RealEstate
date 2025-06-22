import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BidService {
  private apiUrl = 'http://localhost:8080/api/bids/place'; // Update if needed

  constructor(private http: HttpClient) {}

  placeBid(data: any) {
    return this.http.post(`${this.apiUrl}/place`, data);
  }

  getBids(propertyId: number) {
    return this.http.get<any[]>(`${this.apiUrl}/property/${propertyId}`);
  }
}
