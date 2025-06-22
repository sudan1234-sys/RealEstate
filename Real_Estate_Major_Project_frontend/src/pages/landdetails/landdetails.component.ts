import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Land } from '../../models/landmodel';
@Component({
  selector: 'app-landdetails',
  imports: [CommonModule],
  templateUrl: './landdetails.component.html',
  styleUrl: './landdetails.component.scss'
})
export class LanddetailsComponent {
land!: Land;
  currentPhotoIndex = 0;

  constructor(private router: Router) {
    const nav = this.router.getCurrentNavigation();
    this.land = nav?.extras?.state as Land;
    console.log(this.land); 
  }

  scroll(direction: number) {
    this.currentPhotoIndex += direction;
    if (this.currentPhotoIndex < 0) {
      this.currentPhotoIndex = this.land.landphotos.length - 1;
    }
    if (this.currentPhotoIndex >= this.land.landphotos.length) {
      this.currentPhotoIndex = 0;
    }

    const container = document.querySelector('.scroll-smooth');
    if (container) {
      container.scrollTo({
        left: (container as HTMLElement).clientWidth * this.currentPhotoIndex,
        behavior: 'smooth'
      });
    }
  }
}
