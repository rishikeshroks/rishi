import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustloginComponent } from './custlogin.component';
import { DebugElement } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { By } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


describe('CustloginComponent', () => {
  let component: CustloginComponent;
  let fixture: ComponentFixture<CustloginComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustloginComponent ],
      imports: [ReactiveFormsModule,HttpClientModule],
      providers: [
        {provide: Router, useClass: MockRouter},
        {provide: ActivatedRoute, MockActiveRouter}
      ]
    })
    .compileComponents();
  }));
  class MockRouter {}
  class MockActiveRouter {
  }
  beforeEach(() => {
    fixture = TestBed.createComponent(CustloginComponent);
    component = fixture.componentInstance;
    de = fixture.debugElement.query(By.css('form'));
    el = de.nativeElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call the OnSubmit method when submit button is clicked ', async() => {
    fixture.detectChanges();
    spyOn(component, 'onSubmit');
    el = fixture.debugElement.query ( By.css('button')).nativeElement;
    el.click();
    expect(component.onSubmit).toHaveBeenCalledTimes(1);
  });
  it('form should be invalid ', async() => {
    component.loginForm.controls['cUserName'].setValue('');
    component.loginForm.controls['cPassword'].setValue('');
    expect(component.loginForm.valid).toBeFalsy();
  });
  it('form should be valid ', async() => {
    component.loginForm.controls['cUserName'].setValue('ANNE');
    component.loginForm.controls['cPassword'].setValue('ABC@123');
    expect(component.loginForm.valid).toBeTruthy();
  });
});