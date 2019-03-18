import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VendorService } from '../vendor.service';
import { Vendor } from '../vendor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendorlogin',
  templateUrl: './vendorlogin.component.html',
  styleUrls: ['./vendorlogin.component.css']
})
export class VendorloginComponent implements OnInit {
  loginForm :FormGroup;
  submitted = false;
  venlogin: Vendor;
  
  constructor(private formBuilder: FormBuilder,private _router:Router,
    private loginservice:VendorService) { }

  ngOnInit() {
    this.loginForm= this.formBuilder.group({
      venUsername: ['',Validators.required],
      venPassword: ['',[Validators.required, Validators.minLength(4)]]
    
    });
  }
  get f() { return this.loginForm.controls; }
  errorMsg: any;
  myvendor: Vendor;
  loaded: boolean = false;
  
onSubmit() {
  let vendorlogin: Vendor;
  vendorlogin = this.loginForm.value;
  this.loginservice.verifyUNamePassword(vendorlogin.venUsername,vendorlogin.venPassword).subscribe(
    data => {
      this.loaded = true;
      this.myvendor = data;
      console.log(this.myvendor.venId);
      alert("login successful "+ this.myvendor.venName  );
      this.gotoDashboard(this.myvendor.venId);
    },
    error => {
      this.errorMsg = error;
      console.log(this.errorMsg);
      alert('INVALID LOGIN');
    }
  );
  }
  gotoDashboard(venId: any):void{
    this._router.navigate(['vendordashboard',venId]);
    localStorage.setItem('venId',venId);
    
    
    console.log(venId);
  } 
  /*
  console.log(this.loginForm.value);
  this.venlogin = this.loginForm.value;
  if (this.validateLogin()){
      alert('SUCCESS!! :-' + this.venlogin.venUsername + " " + 
        this.venlogin.venPassword);
      let key = 'userName';
      localStorage.setItem(key,this.venlogin.venUsername);
      } else {
        localStorage.removeItem('userName');
      }
}

validateLogin():boolean{
  let c : Vendor;
  c = this.loginservice.validateLogin(this.venlogin);
  if (c == null)
  return false;
  return true;
}*/


}
