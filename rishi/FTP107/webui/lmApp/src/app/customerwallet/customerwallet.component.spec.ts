import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerwalletComponent } from './customerwallet.component';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../customer';
import { custLoginService } from '../customer.service';
import { of } from 'rxjs';

describe('CustomerwalletComponent', () => {
  let httpClient: HttpClient;
  let service: custLoginService;
  let component: CustomerwalletComponent;
  //let fixture: ComponentFixture<CustomerwalletComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerwalletComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    // fixture = TestBed.createComponent(CustomerwalletComponent);
    // component = fixture.componentInstance;
    // fixture.detectChanges();
    service = new custLoginService(httpClient);
    component = new CustomerwalletComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
  it(' should call ngInit with success',() =>{
    let cus = new Customer(3,'ANNE JORELDON','ANNE','ABC@123',309.00,'ANNEJ@GMAIL.COM', '9784561751','NO 39 MAMBALAM CHENNAI-90');
  localStorage.setItem('cid','3')
  spyOn(service, 'showwallet').and.returnValue( of(cus));
  component.ngOnInit();
  expect(component.customer).toEqual(cus);
  expect(component.customer).not.toEqual(null);
  });
});
