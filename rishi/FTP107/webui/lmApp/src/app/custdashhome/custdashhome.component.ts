import { Component, OnInit } from '@angular/core';
import { custLoginService } from 'src/app/customer.service';
import { Customer } from 'src/app/customer';

@Component({
  selector: 'app-custdashhome',
  templateUrl: './custdashhome.component.html',
  styleUrls: ['./custdashhome.component.css']
})
export class CustdashhomeComponent implements OnInit {
  errorMsg:any;
  cid:string ;
  customer: Customer;
  constructor(private customerservice : custLoginService) { }

  ngOnInit() { 
  
  this.cid=localStorage.getItem('custId');
  console.log("localval"+this.cid);
    this.customerservice.showwallet(this.cid)
    .subscribe(
      data =>{
        this.customer = data ,
        
        console.log('data' + this.customer.custName);
    },
    error =>{
      this.errorMsg = error;
      console.log('error' + error);
    }
    );
  }

  }

