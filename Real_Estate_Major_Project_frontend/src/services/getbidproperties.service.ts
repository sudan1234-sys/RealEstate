import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { House } from '../models/housemodel';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root'
})
export class GetbidpropertiesService {

  constructor(private http: HttpClient) { }

  getBidProperties() {
    return this.http.get<House[]>(`$environment.baseUrl}/users/bid-properties`);
  }
}
