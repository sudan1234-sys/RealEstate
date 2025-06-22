import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';
import { House } from '../models/housemodel';
import { environment } from '../environment';


@Injectable({
  providedIn: 'root'
})
export class FilterserviceService {
  houses=signal<House[]>([]);
  property=signal<House[]>([]);
  uniqueCities: string[] = [];

  constructor(private http: HttpClient) { }

  async getfilteredstate(state: string): Promise<void> {
    const data = await firstValueFrom(
      this.http.get<any[]>(`${environment.baseUrl}/users/filtered-properties/${state}`)
    );
    // this.houses.set(data);
    this.houses.set(data.map(house => ({
      ...house,
      saved: false // Initialize saved state as false
    })));
    console.log(this.houses());
    // Get unique cities using Set
    this.uniqueCities = [...new Set(data.map(house => house.city))];
  }
  getpropertybycity(city: string): House[] {
    this.property.set(this.houses().filter(house => house.city === city));
    localStorage.setItem('property', JSON.stringify(this.property()));
    return this.property();
  }
}
