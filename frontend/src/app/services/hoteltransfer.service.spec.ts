import { TestBed } from '@angular/core/testing';

import { HotelTransfer } from './hoteltransfer.service';

describe('HoteltransferService', () => {
  let service: HotelTransfer;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HotelTransfer);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
