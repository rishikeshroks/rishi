import { TestBed , inject } from 

'@angular/core/testing';
import {   HttpClient } from '@angular/common/http';

import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { OrdersServiceService } from './orders.service';

import { Observable } from 'rxjs';
import { Orders } from 'src/app/orders';

describe('OrdersServiceService', () => {
  let service : OrdersServiceService;
  let httpMock :HttpTestingController;
  let str1 : string= "2019-03-12 18:25:49";
  let date1 = new Date(str1);
  beforeEach(() => { 
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers:[OrdersServiceService]
    });          
    service = TestBed.get(OrdersServiceService);
    httpMock = TestBed.get

(HttpTestingController);
  });
  it('Customer order history service is working',()=>{
    const orders:Orders[] = [
      new Orders(113, 3, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering'),
      
    ];
      
    
    service.getcustomerordershistory('3').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(orders);
      });
      let url = "http://localhost:8080/FTP107/api/orders/cust/3"
    const request = httpMock.expectOne(url);
    expect(request.request.method).toBe('GET');
    request.flush(orders);

  });
 


  it('Vendor order history service is working',()=>{
    const orders:Orders[] = [
      new Orders(113, 3, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering'),
      
    ];
      
    
    service. getvendororderhistory('500').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(orders);
      });
      let url = "http://localhost:8080/FTP107/api/orders/ven/500"
    const request = httpMock.expectOne(url);
    expect(request.request.method).toBe('GET');
    request.flush(orders);

  });


  it('all orders is working',()=>{
    const orders:Orders[] = [
      new Orders(113, 3, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering'),
      
    ];
      
    
    service. getplacedorder('500').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(orders);
      });
      let url = "http://localhost:8080/FTP107/api/orders/placed/500"
    const request = httpMock.expectOne(url);
    expect(request.request.method).toBe('GET');
    request.flush(orders);

  });


  it('place order by post method is working',()=>{
    let cid:any='3';
    const orders:Orders =new Orders(113, 3, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering');
      
    
    service. postOrderData(orders,cid).subscribe(
      (data) => {
        //expect(data.length).toBe(1);
        expect(data).toEqual(orders);
      });
      
    const request = httpMock.expectOne(service.posturl);
    expect(request.request.method).toBe('POST');
    request.flush(orders);

  });



  it('accept deny by put method is working',()=>{
    let oid:any='113';
    const orders :Orders[] =[
      new Orders(113, 3, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering')
    ];
    const oneOrder :Orders =
      new Orders(113, 3, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering')
    ;
      
    
    service. putOrderData(oneOrder,oid).subscribe(
      (data) => {
        //expect(data.length).toBe(1);
        expect(data).toEqual(orders);
      });
      
    const request = httpMock.expectOne(service.puturl);
    expect(request.request.method).toBe('PUT');
    request.flush(orders);

  });

  afterEach(() => { 
    httpMock.verify();
  });
});


/**import { TestBed } from '@angular/core/testing';

import { OrdersServiceService } from './orders.service';

xdescribe('OrdersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  xit('should be created', () => {
    const service: OrdersServiceService = TestBed.get(OrdersServiceService);
    expect(service).toBeTruthy();
  });
});
*/