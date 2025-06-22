import { Component, ElementRef, AfterViewInit, ViewChild } from '@angular/core';
import { trigger, state, style, animate, transition } from '@angular/animations';
import { AnimateOnScrollDirective, SCROLL_ANIMATIONS } from '../../animations/animate-on-scroll.directive';
import { House } from '../../models/housemodel';
import { Land } from '../../models/landmodel';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { TophouseandlandService } from '../../services/tophouseandland.service';
import { FilterserviceService } from '../../services/filterservice.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { RouterLink } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CardskeletonComponent } from '../cardskeleton/cardskeleton.component';

@Component({
  selector: 'app-home-page',
  imports: [MatAutocompleteModule,RouterLink, MatInputModule, MatFormFieldModule,AnimateOnScrollDirective,CommonModule,ReactiveFormsModule,FormsModule,MatProgressSpinnerModule,CardskeletonComponent],
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
  animations: [SCROLL_ANIMATIONS,
    trigger('fadeInOut', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('500ms', style({ opacity: 1 }))
      ]),
      transition(':leave', [
        style({ opacity: 1 }),
        animate('500ms', style({ opacity: 0 }))
      ])
    ])
  ] 
})  
export class HomePageComponent  {
  contactusform:FormGroup;
  @ViewChild('listings') listingsSection!: ElementRef;
  searchvalue:string='';
  toggleState:boolean=false;
  isReady:boolean=false;
  
  filterdStates:string[]=["Andhra Pradesh",
    "Arunachal Pradesh",
    "Assam",
    "Bihar",
    "Chhattisgarh",
    "Goa",
    "Gujarat",
    "Haryana",
    "Himachal Pradesh",
    "Jharkhand",
    "Karnataka",
    "Kerala",
    "Madhya Pradesh",
    "Maharashtra",
    "Manipur",
    "Meghalaya",
    "Mizoram",
    "Nagaland",
    "Odisha",
    "Punjab",
    "Rajasthan",
    "Sikkim",
    "Tamil Nadu",
    "Telangana",
    "Tripura",
    "Uttar Pradesh",
    "Uttarakhand",
    "West Bengal",

    "Chandigarh",
  
    "Lakshadweep",
    "Delhi",
    "Puducherry",
    "Ladakh",
  ];
  selectedState:string='';
   indianStates:string[] = [
    "Andhra Pradesh",
    "Arunachal Pradesh",
    "Assam",
    "Bihar",
    "Chhattisgarh",
    "Goa",
    "Gujarat",
    "Haryana",
    "Himachal Pradesh",
    "Jharkhand",
    "Karnataka",
    "Kerala",
    "Madhya Pradesh",
    "Maharashtra",
    "Manipur",
    "Meghalaya",
    "Mizoram",
    "Nagaland",
    "Odisha",
    "Punjab",
    "Rajasthan",
    "Sikkim",
    "Tamil Nadu",
    "Telangana",
    "Tripura",
    "Uttar Pradesh",
    "Uttarakhand",
    "West Bengal",

    "Chandigarh",
  
    "Lakshadweep",
    "Delhi",
    "Puducherry",
    "Ladakh",
  
];
toggle:boolean=false;
city:string='';
  state: string = '';
  cities: string[] = [];  
  properties:House[]=[];
  searchResults: string[] = [];
  top4house: House[] = [];
  top4land: Land[] = [];
  isLoadingHouses = true;
  isLoadingLands = true;
  constructor(private tophouseandlandService: TophouseandlandService,private filterserviceService: FilterserviceService ,private router:Router ,private fb: FormBuilder,private http:HttpClient) {
    this.contactusform=this.fb.group({
      name:['',Validators.required],
      email:['',Validators.required],
      message:['',Validators.required]
    });
   } 
  ngOnInit(): void {
  
    this.tophouseandlandService.getTopHouse().subscribe(data => {
      this.top4house = data;
       this.isLoadingHouses = false;
      console.log(this.top4house);
    });
 
    this.tophouseandlandService.getTopLand().subscribe(data => {
      this.top4land = data;
        this.isLoadingLands = false;
    });


  }
 
  async getState(state: string) {
    this.isReady=true;
   
   
    // This will wait for the HTTP call to complete
    await this.filterserviceService.getfilteredstate(state);
    
    
    console.log(this.filterserviceService.uniqueCities);
    this.cities = this.filterserviceService.uniqueCities;
    this.isReady=false;
    this.searchResults = this.filterserviceService.uniqueCities;
  }
  togglesearch(){
   
   this.toggle=!this.toggle;
   console.log(this.toggle);
 
  }
 filterCity(){

    if(!this.searchvalue){
      this.searchResults=this.cities;
    }
    this.searchResults=this.cities;
    this.searchResults = this.searchResults.filter(city => city.toLowerCase().includes(this.searchvalue.toLowerCase()));
    console.log(this.searchResults);
    console.log('hii');
    console.log(this.searchvalue);


  this.properties=this.filterserviceService.getpropertybycity(this.searchvalue);
  console.log(this.properties);



  }
  
  goToDummy(){
    setTimeout(() => {
      this.router.navigate(['dummypage']);
    }, 1000);
  

  }
  fillsearch(city:string){
     this.searchvalue=city;
      this.filterCity();
  
   
  } 
  scrollToListings() {
    this.listingsSection.nativeElement.scrollIntoView({ behavior: 'smooth' });
  }
  gotosignup(){
    this.router.navigate(['signup']);
  }
  toggleStateDropdown(){
    this.toggleState=!this.toggleState;
  }
  async filterstate(){
    
    // const city='';
    if(!this.selectedState){
      this.searchResults=[];
       this.filterdStates=this.indianStates;
      
    }
    this.filterdStates=this.indianStates;
   this.filterdStates=this.filterdStates.filter(state => state.toLowerCase().includes(this.selectedState.toLowerCase()));
   
  for(let state of this.filterdStates){
    if(state==this.selectedState){
      this.getState(state);
      break;
    }
  }
    
  }
  onSubmit(){
    console.log(this.contactusform.value);
   this.http.post('http://localhost:8080/api/contact',this.contactusform.value,{ responseType: 'text' }).subscribe(res=>{
     alert(res);
   })
  }
    gotopropertydetails(house:House){
    this.router.navigate(['propertydetails'],{state:house});
  }
    gotoLanddetails(land:Land){
    this.router.navigate(['landdetails'],{state:land});
  }
  navigatetoactivebid(){
    this.router.navigate(['activebidproperties']);
  }
}
