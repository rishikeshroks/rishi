import { TestBed } from '@angular/core/testing';
import {HttpClientTestingModule,HttpTestingController} from '@angular/common/http/testing';
import { custLoginService } from './customer.service';
import { Customer } from './customer';

describe('CustomerService', () => {
  let httpMock :HttpTestingController;
  let service : custLoginService;
  beforeEach(() => { 
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers:[custLoginService]
    });          
    service = TestBed.get(custLoginService);
    httpMock = TestBed.get(HttpTestingController);
  });
  it('show wallet - sample http mocking',()=>{
    const customer: Customer = new Customer(3,'ANNE JORELDON','ANNE','ABC@123',309.00,'ANNEJ@GMAIL.COM', '9784561751','NO 39 MAMBALAM CHENNAI-90')
    service.showwallet('3').subscribe(
    (data) => {
        expect(data).toEqual(customer);
    });
    let myurl = "http://localhost:8080/FTP107/api/customer/showwallet/3";
    const request = httpMock.expectOne(myurl);
    expect(request.request.method).toBe('GET');
    request.flush(customer);
    
    });
    afterEach(() => { 
    httpMock.verify();
    });
    
    });