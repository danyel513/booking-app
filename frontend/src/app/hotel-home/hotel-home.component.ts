import { Component, OnInit, Renderer2 } from '@angular/core';
import { HotelTransfer } from '../services/hoteltransfer.service';
import { Hotel } from '../../types';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-hotel-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './hotel-home.component.html',
  styleUrl: './hotel-home.component.css'
})
export class HotelHomeComponent implements OnInit{
      hotel: null |  Hotel = {
      name: '',
      address: '',
      phone: '',
      email: '',
      idHotels: 0,
      city: '',
      state: '',
    };

    rooms = [
      { type: 'Single Room', status: 'Disponibilă' },
      { type: 'Double Room', status: 'Disponibilă' },
      { type: 'Triple Room', status: 'Disponibilă' },
      { type: 'Apartament', status: 'Disponibilă' },
      { type: 'Suite', status: 'Disponibilă' },
      { type: 'Deluxe Suite', status: 'Disponibilă' }
    ];

    constructor(private hotelTrans: HotelTransfer, private renderer: Renderer2) {}

    ngOnInit() {
      this.hotelTrans.hotel$.subscribe(hotel => {
        this.hotel = hotel;
      });
      console.log(this.hotel);
    }

    changeStatus(index: number) {
      const currentStatus = this.rooms[index].status;
      this.rooms[index].status = currentStatus === 'Disponibilă' ? 'În mentenanță' : 'Disponibilă';
    }

    onSubmit(form: any) {
      if (this.hotel) {
        this.hotel.name = form.value.name;
        this.hotel.address = form.value.address;
        this.hotel.phone = form.value.phone;
        this.hotel.email = form.value.email;
        console.log(this.hotel);
      }
    }

    scrollToSection(sectionId: string) {
      const element = document.getElementById(sectionId);
      if (element) {
        element.scrollIntoView({ behavior: 'smooth' });
      }
    }
  
}
