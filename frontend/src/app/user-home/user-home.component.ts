import { Component } from '@angular/core';
import { HotelImg } from '../../types';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-home.component.html',
  styleUrl: './user-home.component.css'
})
export class UserHomeComponent {
  user: any = { 
    name: 'John Doe',
    email: 'john@example.com',
    phone: '1234567890'
  };

  hotels: HotelImg[] = [ 
    {
      name: 'Vila Serenissima, Maldives',
      imageUrl: '../../assets/img/hotel1.jpg',
      description: 'Descoperiți o oază de rafinament și lux în inima Maldivelor, la Vila Serenissima. Situată pe o insulă privată în mijlocul oceanului Indian, această reședință de lux oferă intimitate și eleganță. Cu vile private amplasate pe stâlpii deasupra apei cristaline și servicii personalizate de prim rang, vila promite o experiență paradisiacă și memorabilă.'
    },
    {
      name: 'Palatul Regal, Marrakech',
      imageUrl: '../../assets/img/hotel2.jpg',
      description: 'Întruchipând splendoarea și bogăția culturii marocane, Palatul Regal din Marrakech vă întâmpină într-o lume de opulență și mister. Cu arhitectură arabescă sofisticată, grădini luxuriante și suite regale ornate cu tapițerii fine și obiecte de artă exotice, acesta este locul ideal pentru cei care caută să se bucure de luxul oriental autentic.'
    },
    {
      name: 'Vila Eden, Santorini',
      imageUrl: '../../assets/img/hotel3.jpg',
      description: 'Situată pe coastele albe și stâncoase ale insulei grecești Santorini, Vila Eden vă îmbie cu priveliști uimitoare asupra Mării Egee și ale apusurilor de soare spectaculoase. Cu arhitectură cicladică tradițională și facilități moderne de prim rang, această vilă exclusivistă oferă o escapadă romantică și relaxantă într-un cadru idilic.'
    },
    {
      name: 'Hotelul Aurora, Alaska',
      imageUrl: '../../assets/img/hotel4.jpg',
      description: 'Experimentați frumusețea sălbatică a Alaskăi la Hotelul Aurora, situat în inima tundrei arctice. Împrejmuit de munți impunători și înconjurat de natură sălbatică, acest hotel oferă o priveliște senzațională a dansului fascinant al luminilor nordului. Cu camere confortabile și activități unice precum drumeții pe ghețari și expediții de observare a urșilor polari, Hotelul Aurora promite o aventură neuitată în sălbăticia Alaskăi'
    },
    
  ];

  currentSlide = 0;

  constructor() { }

  ngOnInit(): void {
  }

  nextSlide() {
    if (this.currentSlide < this.hotels.length - 1) {
      this.currentSlide++;
    }
  }

  prevSlide() {
    if (this.currentSlide > 0) {
      this.currentSlide--;
    }
  }

  makeReservation(hotel: HotelImg) {
    // Implementează logica pentru a face o rezervare la hotelul selectat
  }
}
