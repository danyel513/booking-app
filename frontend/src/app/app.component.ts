import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SigninComponent } from './signin/signin.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, 
    ReactiveFormsModule, 
    SignupComponent, 
    FormsModule, 
    RouterModule,
    SigninComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'booking-app';
}
