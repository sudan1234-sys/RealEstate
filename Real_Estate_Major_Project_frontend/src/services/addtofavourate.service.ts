import { Injectable } from '@angular/core';
import { House } from '../models/housemodel';
@Injectable({
  providedIn: 'root'
})
export class AddtofavourateService {
  savedProperties: any[] = [];
  constructor() { }

  addTowishlist(property: any){
    const index = this.savedProperties.findIndex(p => p.id === property.id);
    
    if (index > -1) {
      this.savedProperties.splice(index, 1);
    } else {
      this.savedProperties.push(property);
    }
  }
  removeFromwishlist(property: any){
   this.savedProperties.splice(this.savedProperties.indexOf(property), 1);
  }
}
