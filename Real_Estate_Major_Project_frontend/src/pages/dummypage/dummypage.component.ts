import { Component, OnInit } from '@angular/core';
import { House } from '../../models/housemodel';
import { Router } from '@angular/router';
import { FilterserviceService } from '../../services/filterservice.service';
import { AddtofavourateService } from '../../services/addtofavourate.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-dummypage',
  standalone: true,
  imports: [CommonModule, FormsModule, MatIconModule],
  templateUrl: './dummypage.component.html',
  styleUrls: ['./dummypage.component.scss']
})
export class DummypageComponent implements OnInit {
  filteredProperties: House[] = [];
  saved = false;

  // Filters
  propertyTypes = ['House', 'Apartment', 'Villa', 'Condo', 'Land'];
  priceRanges = [
    { label: 'Under ₹50L', value: '0-5000000' },
    { label: '₹50L - ₹1Cr', value: '5000000-10000000' },
    { label: '₹1Cr - ₹2Cr', value: '10000000-20000000' },
    { label: 'Over ₹2Cr', value: '20000000-100000000' }
  ];
  bedroomOptions = [1, 2, 3, 4, 5];
  bathroomOptions = [1, 2, 3, 4];

  selectedType = '';
  selectedPrice = '';
  selectedBedrooms = '';
  selectedBathrooms = '';

  property: House[] = [];

  constructor(
    private router: Router,
    private filterService: FilterserviceService,
    public addtofavourateService: AddtofavourateService
  ) {}

  ngOnInit() {
    this.property = this.filterService.property();
  }

  applyFilters() {
    let filtered = this.filterService.property();

    if (this.selectedType) {
      filtered = filtered.filter(p => p.type === this.selectedType);
    }

    if (this.selectedPrice) {
      const [min, max] = this.selectedPrice.split('-').map(Number);
      filtered = filtered.filter(p => p.price >= min && p.price <= max);
    }

    if (this.selectedBedrooms) {
      filtered = filtered.filter(p => p.bedrooms >= +this.selectedBedrooms);
    }

    if (this.selectedBathrooms) {
      filtered = filtered.filter(p => p.bathrooms >= +this.selectedBathrooms);
    }

    this.property = filtered;
  }

  goToHome() {
    this.router.navigate(['']);
  }

  gotosavedproperties() {
    this.router.navigate(['savedproperties']);
  }

  gotopropertydetails(house: House) {
    this.router.navigate(['propertydetails'], { state: house });
  }

  toggleSave(property: House) {
    property.saved = !property.saved;
    this.addtofavourateService.addTowishlist(property);
  }

  contactSeller(seller: any) {
    alert(`Contacting ${seller.name} at ${seller.email}`);
  }
}
