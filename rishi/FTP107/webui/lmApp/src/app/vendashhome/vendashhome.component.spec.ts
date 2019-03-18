import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendashhomeComponent } from './vendashhome.component';
import { HttpClientModule } from '@angular/common/http';
import { VendorService } from 'src/app/vendor.service';
import { HttpClient } from '@angular/common/http';

describe('VendashhomeComponent', () => {
  let httpclient:HttpClient;
  let service : VendorService
  let component: VendashhomeComponent;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendashhomeComponent ],
      imports:[HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new VendorService(httpclient);
    component = new VendashhomeComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
