import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Hotel, User } from '../../types';

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


@Injectable({
  providedIn: 'root'
})
export class UserTransfer {
  private userSubject = new BehaviorSubject<User | null>(null);
  user$ = this.userSubject.asObservable();

  constructor() {}

  setUser(user: User) {
    this.userSubject.next(user);
  }

  getUser(): User | null{
    return this.userSubject.getValue();
  }
}

