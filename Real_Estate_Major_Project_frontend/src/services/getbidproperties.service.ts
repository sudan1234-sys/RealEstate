import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { House } from '../models/housemodel';

@Injectable({
  providedIn: 'root'
})
export class GetbidpropertiesService {

  constructor(private http: HttpClient) { }

  getBidProperties() {
    return this.http.get<House[]>('http://localhost:8080/property/active');
  }
}
