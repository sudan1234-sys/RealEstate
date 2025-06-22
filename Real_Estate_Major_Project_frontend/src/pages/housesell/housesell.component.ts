import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { environment } from '../../environment';

@Component({
  selector: 'app-housesell',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './housesell.component.html',
  styleUrls: ['./housesell.component.scss']
})
export class HousesellComponent {
  propertyForm: FormGroup;
  currentDateIso = new Date().toISOString().slice(0,16);

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.propertyForm = this.fb.group({
      // Location
      street:     ['', Validators.required],
      city:       ['', Validators.required],
      state:      ['', Validators.required],
      postalCode: ['', Validators.required],

      // Auction toggle + fields
      isAuction:       [false],
      endTime:      [''],
      minBidIncrement: [''],

      // Price
      price: ['', [Validators.required, Validators.min(0)]],

      // Basics
      type:      ['House', Validators.required],
      bedrooms:  ['', [Validators.required, Validators.min(0)]],
      bathrooms: ['', [Validators.required, Validators.min(0)]],

      // Specs
      squareFootage: ['', [Validators.min(0)]],
      yearBuilt:     ['', [Validators.min(1800)]],
      garage:        ['', [Validators.min(0)]],
      landSize:      [''],

      // Features & Photos
      features: this.fb.array([]),
      photos:   this.fb.array([ this.createPhotoField() ]),

      // Description
      description: ['']
    });

    this.propertyForm.get('isAuction')!
      .valueChanges
      .subscribe(flag => this.toggleAuctionValidators(flag));
  }

  get features(): FormArray { return this.propertyForm.get('features') as FormArray; }
  get photos():   FormArray { return this.propertyForm.get('photos')   as FormArray;   }

  private createPhotoField() {
    return this.fb.group({ photoUrl: ['', Validators.required] });
  }

  addFeature() { this.features.push(this.fb.control('', Validators.required)); }
  removeFeature(i: number) { this.features.removeAt(i); }

  addPhoto() { this.photos.push(this.createPhotoField()); }
  removePhoto(i: number) {
    if (this.photos.length > 1) this.photos.removeAt(i);
  }

  private toggleAuctionValidators(isAuction: boolean) {
    const endCtl = this.propertyForm.get('endTime')!;
    const incCtl = this.propertyForm.get('minBidIncrement')!;

    if (isAuction) {
      endCtl.setValidators([Validators.required]);
      incCtl.setValidators([Validators.required, Validators.min(100)]);
    } else {
      endCtl.clearValidators();
      incCtl.clearValidators();
    }

    endCtl.updateValueAndValidity();
    incCtl.updateValueAndValidity();
  }

  onSubmit() {
    if (this.propertyForm.invalid) {
      this.propertyForm.markAllAsTouched();
      return;
    }

    const fv = this.propertyForm.value;
    const payload: any = {
      ...fv,
      features: fv.features.map((f: string) => ({ feature: f })),
      photos:   fv.photos.map((p: any)   => ({ photoUrl: p.photoUrl })),
      listingDate: new Date().toISOString()
    };

    if (!fv.isAuction) {
      delete payload.auctionEnd;
      delete payload.minBidIncrement;
    }

    console.log('Submitting:', payload);
    this.http.post(`${environment.baseUrl}/property/saveProperty/1`, payload)
      .subscribe({
        next: () => this.router.navigate(['/']),
        error: err => console.error('Save failed', err)
      });
  }

  gotopriceprediction() {
    this.router.navigate(['/houseprice']);
  }
}
