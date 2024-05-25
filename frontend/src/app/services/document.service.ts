import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  get nativeDocument(): Document {
    return document;
  }
}
