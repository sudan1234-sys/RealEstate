// activebidproperties.component.ts
import { Component } from '@angular/core';
import { GetbidpropertiesService } from '../../services/getbidproperties.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ActivebidskeletonComponent } from '../activebidskeleton/activebidskeleton.component';

@Component({
  selector: 'app-activebidproperties',
  standalone: true,
  imports: [CommonModule,ActivebidskeletonComponent],
  templateUrl: './activebidproperties.component.html',
  styleUrls: ['./activebidproperties.component.scss']
})
export class ActivebidpropertiesComponent {
  properties: any[] = [];
  isLoading = true;

  constructor(
    private getBidPropertiesService: GetbidpropertiesService,
    private router: Router
  ) {
    this.loadProperties();
  }

  private loadProperties() {
    this.getBidPropertiesService.getBidProperties().subscribe(data => {
      this.properties = data;
      this.isLoading = false;
    });
  }

  getRemainingTime(endDateStr: string): string {
    if (!endDateStr) return 'N/A';
    const endDate = new Date(endDateStr);
    const now = new Date();
    const diff = endDate.getTime() - now.getTime();
    if (diff <= 0) return 'Expired';
    
    const days = Math.floor(diff / (1000 * 60 * 60 * 24));
    const hours = Math.floor((diff / (1000 * 60 * 60)) % 24);
    const minutes = Math.floor((diff / (1000 * 60)) % 60);
    return `${days}d ${hours}h ${minutes}m`;
  }

navigateToProperty(property: any) {
  console.log(property);
  this.router.navigate(['/bidingsystem'], {
    state: {
      propertyData: property // Pass full object
    }
  });
}
}