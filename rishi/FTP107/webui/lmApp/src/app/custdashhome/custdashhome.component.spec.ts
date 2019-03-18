import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustdashhomeComponent } from './custdashhome.component';
import { HttpClientModule } from '@angular/common/http';
import { custLoginService } from 'src/app/customer.service';
import { HttpClient } from '@angular/common/http';


describe('CustdashhomeComponent', () => {

  let httpclient:HttpClient;
  let service : custLoginService;
  let component: CustdashhomeComponent;


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustdashhomeComponent ],
      imports:[HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new custLoginService(httpclient);
    component = new CustdashhomeComponent(service);
  });

  it('should create radha', () => {
    expect(component).toBeTruthy();
  });
});
