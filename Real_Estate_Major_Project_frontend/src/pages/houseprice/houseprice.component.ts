import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-houseprice',
  imports: [FormsModule,CommonModule],
  templateUrl: './houseprice.component.html',
  styleUrl: './houseprice.component.scss'
})
export class HousepriceComponent {
 
  formData = {
    square_ft: '',
    latitude: '',
    longitude: '',
    posted_by: '0',
    ready_to_move: '1',
    under_construction: '0'
  };

  predictedPrice: number | null = null;

  constructor(private http: HttpClient) {}

  predict() {
    const apiUrl = 'http://127.0.0.1:5000/predict';  // Your Flask API endpoint

    this.http.post<any>(apiUrl, this.formData).subscribe({
      next: res => this.predictedPrice = res.predicted_price_lacs,
      error: err => alert('Error: ' + err.error?.error || 'Server Error')
    });
  }

}
