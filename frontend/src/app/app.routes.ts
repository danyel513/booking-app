import { Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { HotelHomeComponent } from './hotel-home/hotel-home.component';

export const routes: Routes = [
    {
        path: '',
        component: SignupComponent
    },
    
    { 
        path: 'hotel-home', 
        component: HotelHomeComponent 
    }
];
