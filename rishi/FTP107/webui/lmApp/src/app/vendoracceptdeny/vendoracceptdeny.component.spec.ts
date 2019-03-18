import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendoracceptdenyComponent } from './vendoracceptdeny.component';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('VendoracceptdenyComponent', () => {
  let component: VendoracceptdenyComponent;
  let fixture: ComponentFixture<VendoracceptdenyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendoracceptdenyComponent ],
      imports: [HttpClientTestingModule, RouterTestingModule],
      schemas:[NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendoracceptdenyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
