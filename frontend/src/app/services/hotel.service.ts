import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../../types';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  private apiUrl = 'http://localhost:8080/api/posthotels';
  private getApiUrl = 'http://localhost:8080/api/gethotels';
  constructor(private http: HttpClient) { }

  getHotels(): Observable<Hotel>
  {
    return this.http.get<Hotel>(this.getApiUrl);
  }

  createHotel(hotel: Hotel): Observable<Hotel> 
  {
    return this.http.post<Hotel>(this.apiUrl, hotel);
  }
}
