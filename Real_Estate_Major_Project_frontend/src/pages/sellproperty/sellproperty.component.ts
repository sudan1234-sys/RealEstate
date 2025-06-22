import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sellproperty',
  imports: [CommonModule],
  templateUrl: './sellproperty.component.html',
  styleUrl: './sellproperty.component.scss'
})
export class SellpropertyComponent {
  selectedType: 'land' | 'house' | null = null;

  selectPropertyType(type: 'land' | 'house') {
    this.selectedType = type;
  }
  constructor(private router:Router){

  }

  continueToForm() {
    if (this.selectedType) {
      // Navigate to the appropriate form based on selection
      console.log(`Proceeding to ${this.selectedType} form`);
      // this.router.navigate([`/sell/${this.selectedType}`]);
    }
    if(this.selectedType==="house"){
      this.router.navigate(['/house']);
    }
    else{
      this.router.navigate(['/land'])
    }
  }
}
