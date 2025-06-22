import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { House } from '../models/housemodel';
import { Land } from '../models/landmodel';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root'
})
export class TophouseandlandService {
  house: House[] = [];
  Land: Land[] = [];
// this.http.get(`${environment.baseUrl}
  constructor(private http: HttpClient) { }
  getTopHouse() {
    return this.http.get<House[]>(`${environment.baseUrl}users/all-properties`);
  }
  getTopLand() {
    return this.http.get<Land[]>(`${environment.baseUrl}users/all-lands`);
  }
}
