import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustdashboardComponent } from './custdashboard.component';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { RouterTestingModule } from '@angular/router/testing';

describe('CustdashboardComponent', () => {
  let component: CustdashboardComponent;
  let fixture: ComponentFixture<CustdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustdashboardComponent ],
      imports : [RouterTestingModule],
      schemas: [NO_ERRORS_SCHEMA]
    })
    
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
