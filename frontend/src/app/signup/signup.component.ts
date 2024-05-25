import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DocumentService } from '../services/document.service';
import { HotelService } from '../services/hotel.service';
import { UserService } from '../services/user.service';
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  standalone: true,
  imports: [ReactiveFormsModule]
})
export class SignupComponent implements OnInit {
  userForm: FormGroup;
  hotelForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private documentService: DocumentService,
    private hotel: HotelService,
    private userService: UserService,
    private router: Router 
  ) {
    this.userForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });

    this.hotelForm = this.formBuilder.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  ngOnInit(): void {
    const doc = this.documentService.nativeDocument;
    const userTypeSelection = doc.querySelectorAll('input[name="user-type"]');
    const userFormElement = doc.getElementById('user-form') as HTMLElement;
    const hotelFormElement = doc.getElementById('hotel-form') as HTMLElement;

    userTypeSelection.forEach(radio => {
      radio.addEventListener('change', (event: Event) => {
        const target = event.target as HTMLInputElement;
        if (target.value === 'user') {
          userFormElement.classList.add('active');
          hotelFormElement.classList.remove('active');
        } else if (target.value === 'hotel') {
          hotelFormElement.classList.add('active');
          userFormElement.classList.remove('active');
        }
      });
    });
  }

  onSubmitUserForm() 
  {
    const userData = this.userForm.value;
    this.userService.createUser(userData).subscribe(response => {
      console.log('User Data:', response);
    });
  }

  onSubmitHotelForm() 
  {
    const hotelData = this.hotelForm.value;
    this.hotel.createHotel(hotelData).subscribe(response => {
      console.log('Hotel Data:', response);
    });
    this.router.navigate(['/hotel-home']);
  }
  
}
