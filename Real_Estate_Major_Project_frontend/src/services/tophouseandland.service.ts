import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { House } from '../models/housemodel';
import { Land } from '../models/landmodel';

@Injectable({
  providedIn: 'root'
})
export class TophouseandlandService {
  house: House[] = [];
  Land: Land[] = [];

  constructor(private http: HttpClient) { }
  getTopHouse() {
    return this.http.get<House[]>('http://localhost:8080/users/all-properties');
  }
  getTopLand() {
    return this.http.get<Land[]>('http://localhost:8080/users/all-lands');
  }
}
