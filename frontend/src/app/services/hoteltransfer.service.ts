import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Hotel } from '../../types';

@Injectable({
  providedIn: 'root'
})
export class HotelTransfer {
  private hotelSubject = new BehaviorSubject<Hotel | null>(null);
  hotel$ = this.hotelSubject.asObservable();

  constructor() {}

  setHotel(hotel: Hotel) {
    this.hotelSubject.next(hotel);
  }

  getHotel(): Hotel | null{
    return this.hotelSubject.getValue();
  }
}
