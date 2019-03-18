import { Component, OnInit } from '@angular/core';
import { OrdersServiceService } from '../orders.service';
import { Orders } from '../orders';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-custorderhistory',
  templateUrl: './custorderhistory.component.html',
  styleUrls: ['./custorderhistory.component.css'],
  providers:[OrdersServiceService]
})
export class CustorderhistoryComponent implements OnInit {
  errorMsg : any;
  cid:string;
  orders: Orders[];
  constructor(private ordersservice : OrdersServiceService
    ) { }

  ngOnInit()  {
    this.cid = localStorage.getItem('custId');
    console.log("localval"+this.cid);
    this.ordersservice.getcustomerordershistory(this.cid)
    .subscribe(
      data => {
        this.orders = data;
        console.log('data' + data);
      },
      error =>{
        this.errorMsg = error;
        console.log('error' + error);
      }
    );
  }

}
