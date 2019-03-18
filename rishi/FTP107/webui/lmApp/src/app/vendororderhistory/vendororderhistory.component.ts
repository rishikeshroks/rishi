import { Component, OnInit } from '@angular/core';
import { OrdersServiceService } from '../orders.service';
import { Orders } from '../orders';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vendororderhistory',
  templateUrl: './vendororderhistory.component.html',
  styleUrls: ['./vendororderhistory.component.css'],
  providers:[OrdersServiceService]
  
})
export class VendororderhistoryComponent implements OnInit {
  errorMsg: any;
  vid: string;
  orders:Orders[];

  constructor(private ordersservice : OrdersServiceService,
    private _router:Router,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit()  {
    this.vid = localStorage.getItem('venId');
    console.log("localval"+this.vid);
    this.ordersservice.getvendororderhistory(this.vid)
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
 