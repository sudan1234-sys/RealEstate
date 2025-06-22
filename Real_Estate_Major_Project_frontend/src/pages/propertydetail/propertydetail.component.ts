import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { House } from '../../models/housemodel';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-propertydetail',
  imports: [CommonModule],
  templateUrl: './propertydetail.component.html',
  styleUrl: './propertydetail.component.scss'
})
export class PropertydetailComponent {
  property: any;

  constructor(private router: Router) {
    const nav = this.router.getCurrentNavigation();
    this.property = nav?.extras?.state;
    console.log(this.property);
  }
  currentPhotoIndex = 0;

  scroll(direction: number) {
    this.currentPhotoIndex += direction;
    if (this.currentPhotoIndex < 0) this.currentPhotoIndex = this.property.photos.length - 1;
    if (this.currentPhotoIndex >= this.property.photos.length) this.currentPhotoIndex = 0;
    
    const container = document.querySelector('.scroll-smooth');
    if (container) {
      container.scrollTo({
        left: container.clientWidth * this.currentPhotoIndex,
        behavior: 'smooth'
      });
    }
  }
  navigatetosaved(){
    this.router.navigate(['savedproperties']);
  }
}
