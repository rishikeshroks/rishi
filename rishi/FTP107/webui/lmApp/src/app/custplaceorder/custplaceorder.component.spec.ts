import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustplaceorderComponent } from './custplaceorder.component';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { RouterModule } from '@angular/router/src/router_module';
import { Router } from '@angular/router/src/router';

describe('CustplaceorderComponent', () => {
  let component: CustplaceorderComponent;
  let fixture: ComponentFixture<CustplaceorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustplaceorderComponent ],
      imports:[FormsModule,
     HttpClientTestingModule,RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustplaceorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
