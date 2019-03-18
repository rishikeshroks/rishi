
import { Component, OnInit } from '@angular/core';
import { Orders } from 'src/app/orders';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { OrdersServiceService } from 'src/app/orders.service';

@Component({
  selector: 'app-vendoracceptdeny',
  templateUrl: './vendoracceptdeny.component.html',
  styleUrls: ['./vendoracceptdeny.component.css'],
  providers:[OrdersServiceService]
})
export class VendoracceptdenyComponent implements OnInit {
 

  errorMsg : any;
  orders: Orders[];
  venId :any=localStorage.getItem('venId');
  oid : any;
  
  
  constructor(private ordersServ : OrdersServiceService,
    private _router:Router,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.ordersServ.getplacedorder(this.venId)
    .subscribe(
      data => this.orders = data,
      error => this.errorMsg = error
    );

  }
  toggleSelect(orders: Orders ,argSel:boolean){
    orders.isSelected = argSel;
   }

   orderid:number;
   
   status:string="ACCEPTED";
  
  putS:boolean = false;
  putstr:any;
  t:any;
  d:any;

  acceptorder():void{
    let ord:Orders;
    for(ord of this.orders){
      if(ord.isSelected == true){
        this.orderid = ord.oid;
        this.venId=localStorage.getItem('venId');;
        this.status=ord.ostatus;
        this.updateOrder(this.orderid,this.venId,this.status,ord.oreason);
        alert('Order ID ' + this.orderid + '  Accepted');
      }
    }
  }
  denyorder():void{
    let ord:Orders;
    for(ord of this.orders){
      if(ord.isSelected == true){
        this.orderid = ord.oid;
        this.venId=localStorage.getItem('venId');;
        this.status=ord.ostatus;
        console.log(ord.oreason);
        this.update1Order(this.orderid,this.venId,this.status,ord.oreason);
        alert('Order ID '+this.orderid+' Denied');
      }
    }
  }
   myFunction() {
    location.reload();
 
   }
  updateOrder(argOid :number,argVenId: any,argOstatus: string,argReason:string) {
  argOstatus="DELIVERED";
    console.log('update order' + argOid + ' ' + argVenId + ' ' + argOstatus );
    let or:Orders= new Orders(argOid,1016,1,argVenId,2,80.0,156,argOstatus,this.t ,this.t,this.d,argReason);
    this.ordersServ.putOrderData(or, argOid)
    .subscribe(
      data => {
         this.putstr = data;
         console.log("DELIVERED",data);
         this.putS = true;
         console.log("putS");
  },
  error => {
    console.log("error",error);
  }
)}
update1Order(argOid :number,argVenId: any,argOstatus: string,argReason:string) {
  argOstatus="CANCELLED";
    console.log('update order' + argOid + ' ' + argVenId + ' ' + argOstatus );
    let or:Orders= new Orders(argOid,1016,1,argVenId,2,80.0,156,argOstatus,this.t ,this.t,this.d,argReason);
    this.ordersServ.putOrderData(or, argOid)
    .subscribe(
      data => {
         this.putstr = data;
         console.log("CANCELLED",data);
         this.putS = true;
         console.log("putS");
  },
  error => {
    console.log("error",error);
  }
)}


}

