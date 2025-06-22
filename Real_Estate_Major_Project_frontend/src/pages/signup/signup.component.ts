import { Component, OnInit, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { effect } from '@angular/core';

@Component({
  selector: 'app-signup',
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent implements OnInit {
  registerForm: FormGroup;
  username=signal('');

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^\+?\d{10}$/)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
    effect(() => {
      this.registerForm.get('name')?.valueChanges.subscribe(name => {
        this.username.set(name);
      });
    });
    
  }
  ngOnInit(): void {
   
   
    
  
  }


  onSubmit() {
    if (this.registerForm.valid) {
      console.log('Form submitted:', this.registerForm.value);
      this.http.post('http://localhost:8080/user/saveuser', this.registerForm.value, { responseType: 'text' }).subscribe(res => {
        console.log(res);
        alert(res);
    
      });
     
    } else {
      this.registerForm.markAllAsTouched();
    }
  }

  
}
