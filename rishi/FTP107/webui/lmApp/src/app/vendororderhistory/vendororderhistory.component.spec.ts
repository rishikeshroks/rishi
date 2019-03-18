import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendororderhistoryComponent } from './vendororderhistory.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { RouterTestingModule } from '@angular/router/testing';
import { OrdersServiceService } from 'src/app/orders.service';
import { of } from 'rxjs';
import { Orders } from 'src/app/orders';

 

describe('VendororderhistoryComponent', () => {
  let component: VendororderhistoryComponent;
  let fixture: ComponentFixture<VendororderhistoryComponent>;
  let service : OrdersServiceService;
  let str1 : string= "2019-03-12 18:25:49";
  let date1 = new Date(str1);


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendororderhistoryComponent ],
      schemas: [NO_ERRORS_SCHEMA],
      imports: [HttpClientTestingModule, RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendororderhistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  xit('should call ngInit with success', () => {
  let ven = [new Orders(113, 1, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering')];

  spyOn(service, 'getvendororderhistory').and.returnValue( of(ven));
  component.ngOnInit();
  expect(component.orders).toEqual(ven);
  expect(component.orders).not.toEqual(null);
})
});
