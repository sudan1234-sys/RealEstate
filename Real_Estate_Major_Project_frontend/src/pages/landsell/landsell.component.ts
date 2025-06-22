import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-landsell',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './landsell.component.html',
  styleUrl: './landsell.component.scss'
})
export class LandsellComponent implements OnInit {
  landForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.landForm = this.fb.group({
      size: ['', [Validators.required, Validators.min(0)]],
      type: ['', Validators.required],
      street: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      postalCode: ['', [Validators.required, Validators.pattern(/^\d{5}(?:[-\s]\d{4})?$/)]],
      country: ['', Validators.required],
      hasUtilities: [false],
      zoning: ['', Validators.required],
      price: ['', [Validators.required, Validators.min(0)]],
      description: ['', [Validators.required, Validators.minLength(50)]],
      photos: this.fb.array([this.createPhotoControl()]),
      features: this.fb.array([this.createFeatureControl()]) 
    });
  }

  ngOnInit(): void {}

  onSubmit() {
    
      console.log('Form Submitted:', this.landForm.value);
      this.http.post('http://localhost:8080/property/saveLand/1', this.landForm.value).subscribe(res => {
        console.log('Response:', res);
      });
      // Handle form submission
    
  }

  // Helper method for error handling
  isFieldInvalid(field: string): boolean {
    const control = this.landForm.get(field);
    return control ? control.invalid && (control.dirty || control.touched) : false;
  }

  // Get error message for a field
  getErrorMessage(field: string): string {
    const control = this.landForm.get(field);
    if (!control) return '';
    
    if (control.hasError('required')) {
      return 'This field is required';
    }
    if (control.hasError('min')) {
      return 'Value must be greater than 0';
    }
    if (control.hasError('pattern')) {
      return 'Invalid postal code format';
    }
    if (control.hasError('minlength')) {
      return 'Description must be at least 50 characters';
    }
    return '';
  }
  get photos() {
    return this.landForm.get('photos') as FormArray;
  }

  createPhotoControl(): FormGroup {
    return this.fb.group({
      photoUrl: ['', [Validators.required, Validators.pattern(/^(http(s?):\/\/.*\.(jpe?g|png|gif))$/)]]
    });
  }

  addPhoto() {
    this.photos.push(this.createPhotoControl());
  }

  removePhoto(index: number) {
    this.photos.removeAt(index);
  }

  // Feature Controls
  get features() {
    return this.landForm.get('features') as FormArray;
  }

  createFeatureControl(): FormGroup {
    return this.fb.group({
      feature: ['', [Validators.required, Validators.minLength(3)]]
    });
  }


  addFeature() {
    this.features.push(this.createFeatureControl());
  }

  removeFeature(index: number) {
    this.features.removeAt(index);
  }

}
