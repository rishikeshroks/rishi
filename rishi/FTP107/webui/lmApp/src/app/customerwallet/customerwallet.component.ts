import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { custLoginService } from '../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-customerwallet',
  templateUrl: './customerwallet.component.html',
  styleUrls: ['./customerwallet.component.css'],
  providers:[custLoginService]
})
export class CustomerwalletComponent implements OnInit {
  errorMsg:any;
  cid:string ;
  customer: Customer;
  cwallet: any;
 
  constructor(private customerservice : custLoginService){}
    ngOnInit()  {
    this.cid=localStorage.getItem('custId');
    console.log("localval"+this.cid);
      this.customerservice.showwallet(this.cid)
      .subscribe(
        data =>{
          this.customer = data ,
          
          console.log('data' + this.customer.custName);
          this.cwallet = this.customer.cwallet;
          localStorage.setItem('cwallet',this.cwallet);
      },
      error =>{
        this.errorMsg = error;
        console.log('error' + error);
      }
      );
    }
  
}
