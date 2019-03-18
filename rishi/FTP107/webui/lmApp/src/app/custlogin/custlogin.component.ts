import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { custLoginService } from 'src/app/customer.service';
import { FormGroup } from '@angular/forms/src/model';
import { Customer } from 'src/app/customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-custlogin',
  templateUrl: './custlogin.component.html',
  styleUrls: ['./custlogin.component.css']
})
export class CustloginComponent implements OnInit {
  errorMsg : any;
  custLogin : Customer;
  loginData : Customer;
  loaded: boolean = false;
  loginForm : FormGroup;

  constructor(private formBuilder : FormBuilder,private _router:Router,
    private custLoginService:custLoginService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      cUserName: ['', Validators.required],
      cPassword:['',[Validators.required,Validators.minLength(5)]]

    });
  }
  onSubmit() {
    let login:Customer;
    login=this.loginForm.value;
    this.custLoginService.validateCustLogin(login.cUserName, login.cPassword).subscribe(
      data=>{
        this.loaded = true;
        this.loginData = data;
        console.log(data);
        alert('login successful '+this.loginData.custName);
        this.gotoDashboard(this.loginData.custId);
      },
      error=>{
        this.errorMsg = error;
        console.log(this.errorMsg);
        alert('INVALID LOGIN');
      }
    );
  }
  gotoDashboard(custId: any):void{
    this._router.navigate(['customerdashboard',custId]);
    localStorage.setItem('custId',custId);
    console.log(custId);
  } 
  get f() {return this.loginForm.controls;}
  

}
