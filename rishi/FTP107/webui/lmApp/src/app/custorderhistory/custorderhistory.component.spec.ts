import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CustorderhistoryComponent } from './custorderhistory.component';
import { HttpClient } from '@angular/common/http/src/client';
import { custLoginService } from 'src/app/customer.service';
import { Observable,of } from 'rxjs';
import { OrdersServiceService } from 'src/app/orders.service';
import { Customer } from 'src/app/customer';
import { Orders } from 'src/app/orders';


describe('CustorderhistoryComponent', () => {
  let httpclient:HttpClient;
  let service : OrdersServiceService;
  let component: CustorderhistoryComponent;
  let fixture: ComponentFixture<CustorderhistoryComponent>;
  let str1 : string= "2019-03-12 18:25:49";
  let date1 = new Date(str1);

  let str2 : string= "2019-03-12 18:25:49";
  let date2 = new Date(str2);

 
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustorderhistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new OrdersServiceService(httpclient);
    component = new CustorderhistoryComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

 
});