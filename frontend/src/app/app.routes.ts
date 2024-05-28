import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { HotelHomeComponent } from './hotel-home/hotel-home.component';
import { SigninComponent } from './signin/signin.component';
import { UserHomeComponent } from './user-home/user-home.component';

export const routes: Routes = [
    {
        path: '',
        component: SignupComponent
    },
    
    {
        path: 'signup',
        component: SignupComponent
    },
    
    { 
        path: 'hotel-home', 
        component: HotelHomeComponent 
    },

    { 
        path: 'signin', 
        component: SigninComponent 
    },

    { 
        path: 'user-home', 
        component: UserHomeComponent 
    }
];
