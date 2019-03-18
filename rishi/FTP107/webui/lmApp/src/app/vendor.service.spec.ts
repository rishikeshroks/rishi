import { TestBed } from '@angular/core/testing';

import { VendorService } from './vendor.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('VendorService', () => {
  beforeEach(() => { 
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });          

  it('should be created', () => {
    const service: VendorService = TestBed.get(VendorService);
    expect(service).toBeTruthy();
  });
});
});
