import { Component, OnInit } from '@angular/core';
import { HotelImg } from '../../types';
import { CommonModule } from '@angular/common';
import { User } from "../../types";
import { UserTransfer } from '../services/hoteltransfer.service';

@Component({
  selector: 'app-user-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-home.component.html',
  styleUrl: './user-home.component.css'
})
export class UserHomeComponent implements OnInit{
  
  user: null | User = { 
    name: '',
    email: '',
    phone: '',
    password: ''
  };

  constructor(private userTrans: UserTransfer) {  }

  ngOnInit(): void {
    this.userTrans.user$.subscribe(user => {
      this.user = user;
    });
    console.log(this.user);
  }


}
