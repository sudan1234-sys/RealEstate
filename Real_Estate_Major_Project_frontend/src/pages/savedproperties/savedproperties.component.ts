import { Component } from '@angular/core';
import { AddtofavourateService } from '../../services/addtofavourate.service';
@Component({
  selector: 'app-savedproperties',
  imports: [],
  templateUrl: './savedproperties.component.html',
  styleUrl: './savedproperties.component.scss'
})
export class SavedpropertiesComponent {
constructor(private addtofavourateService:AddtofavourateService) { }
savedHouses:any[]=[];
  ngOnInit() {
    this.savedHouses=this.addtofavourateService.savedProperties;
    console.log('hello');
    console.log(this.savedHouses);
  } 
  toggleSave(house: any) {
    this.addtofavourateService.removeFromwishlist(house);
    console.log(this.addtofavourateService.savedProperties);
  }
}
