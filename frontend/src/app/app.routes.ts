import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { HotelHomeComponent } from './hotel-home/hotel-home.component';
import { NgModule } from '@angular/core';

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


// @NgModule({
//     imports: [RouterModule.forRoot(routes, { anchorScrolling: 'enabled' })],
//     exports: [RouterModule]
//   })
//   export class AppRoutingModule { }