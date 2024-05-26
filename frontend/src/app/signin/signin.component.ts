import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HotelTransfer, UserTransfer } from '../services/hoteltransfer.service';
import { UserService } from '../services/user.service';
import { HotelService } from '../services/hotel.service';
import { DocumentService } from '../services/document.service';
import { Hotel, User } from '../../types';
@Component({
  selector: 'app-signin',
  standalone: true,
  imports: [FormsModule, CommonModule, ReactiveFormsModule],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent {
  userForm: FormGroup;
  hotelForm: FormGroup;
  
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private documentService: DocumentService,
    private hotel2: HotelService,
    private userService: UserService,
    private hotelTrans: HotelTransfer,
    private userTrans: UserTransfer
  )
  {
    this.userForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(6)]]
  });

  this.hotelForm = this.formBuilder.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]]
  });}

  signinType: string = 'user';

  onTypeChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.signinType = selectElement.value;
  }

  onSubmit() {
    if (this.signinType === 'user')
    {
      const userParam: User = {
        name: this.userForm.value.username,
        email: this.userForm.value.username + "@email.com",
        phone: "+78624533",
        password: this.userForm.value.password
      };
      this.userTrans.setUser(userParam);
      console.log('User Sign In:', userParam);
      this.router.navigate(['user-home']);
    }
    else
    {
      const hotelParam: Hotel = {
      name: this.hotelForm.value.name,
      email: this.hotelForm.value.email,
      address: "str Sunny street, nr 56",
      city: "London",
      state: "United Kindgdon",
      phone: "+78624533",
      idHotels: 0
      };
    this.hotelTrans.setHotel(hotelParam);
    console.log('Hotel Sign In:', hotelParam);
    this.router.navigate(['hotel-home']);
    }
  }
    
  }

