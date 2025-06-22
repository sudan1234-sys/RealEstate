import { Routes } from '@angular/router';
import { HomePageComponent } from '../pages/home-page/home-page.component';
import { DummypageComponent } from '../pages/dummypage/dummypage.component';
import { SignupComponent } from '../pages/signup/signup.component';
import { PropertydetailComponent } from '../pages/propertydetail/propertydetail.component';
import { SellpropertyComponent } from '../pages/sellproperty/sellproperty.component';
import { LandsellComponent } from '../pages/landsell/landsell.component';
import { HousesellComponent } from '../pages/housesell/housesell.component';
import { HousepriceComponent } from '../pages/houseprice/houseprice.component';
import { SavedpropertiesComponent } from '../pages/savedproperties/savedproperties.component';
import { ActivebidpropertiesComponent } from '../pages/activebidproperties/activebidproperties.component';
import { BidingsystemComponent } from '../pages/bidingsystem/bidingsystem.component';
import { LanddetailsComponent } from '../pages/landdetails/landdetails.component';

export const routes: Routes = [
  { path: '', component: HomePageComponent, pathMatch: 'full', data: { animation: 'HomePage' } },
  { path: 'dummypage', component: DummypageComponent, pathMatch: 'full', data: { animation: 'DummyPage' } },
  { path: 'signup', component: SignupComponent, pathMatch: 'full', data: { animation: 'SignupPage' } },
  { path: 'propertydetails', component: PropertydetailComponent, pathMatch: 'full', data: { animation: 'PropertyDetailsPage' } },
  { path: 'sell', component: SellpropertyComponent, pathMatch: 'full', data: { animation: 'SellPage' } },
  { path: 'land', component: LandsellComponent, pathMatch: 'full', data: { animation: 'LandPage' } },
  { path: 'house', component: HousesellComponent, pathMatch: 'full', data: { animation: 'HousePage' } },
  { path: 'houseprice', component: HousepriceComponent, pathMatch: 'full', data: { animation: 'HousePricePage' } },
  { path: 'savedproperties', component: SavedpropertiesComponent, pathMatch: 'full', data: { animation: 'SavedPropertiesPage' } },
  { path: 'activebidproperties', component: ActivebidpropertiesComponent, pathMatch: 'full', data: { animation: 'ActiveBidPropertiesPage' } },
  { path: 'bidingsystem', component: BidingsystemComponent, pathMatch: 'full', data: { animation: 'BidingSystemPage' } },
  { path: 'landdetails', component: LanddetailsComponent, pathMatch: 'full', data: { animation: 'LandDetailsPage' } },
];
