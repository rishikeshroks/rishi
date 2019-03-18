import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from 'src/app/menu.service';
import { Router } from '@angular/router';
import { OrdersServiceService } from 'src/app/orders.service';
import { Menu } from 'src/app/menu';
import { Orders } from 'src/app/orders';
import { custLoginService } from 'src/app/customer.service';
import { Customer } from 'src/app/customer';

@Component({
  selector: 'app-custplaceorder',
  templateUrl: './custplaceorder.component.html',
  styleUrls: ['./custplaceorder.component.css'],
  providers:[MenuServiceService, OrdersServiceService],
  styles: [`
  .ng-invalid {
    border: 2px solid: red;
  
  };
  .ng-valid {
    border: 2px solid : green;
  };
  `]
})
export class CustplaceorderComponent implements OnInit {
  menus: Menu[];
  cust:Customer;
  username:string;
  errorMsg:any;
  newMenu: any;
  _router: any;
  menu: any;
  loaded:boolean = false;
  postS:boolean = false;
  poststr:any ='';
  fId: number;
  qty: number;
  cid: string;
  cwallet:any;
  //totPrice:number = 0;
 //totCal:number;
  totalOrderPrice:number;
  totalOrderCal:number;
  constructor(private router:Router,private orderService:OrdersServiceService,
    private menuService : MenuServiceService,private custService :custLoginService) { }

  ngOnInit() {
     this.menuService.getMenu().subscribe(
    data => this.menus = data,
    error => this.errorMsg = error 
 );

 this.custService.showwallet(this.cid)
 .subscribe(
   data =>{
     this.cust = data ,
     
     console.log('data' + this.cust.cwallet);
 },
 error =>{
   this.errorMsg = error;
   console.log('error' + error);
 }
 );
  }
  toggleSelect(menu : Menu ,argSel:boolean){
    menu.isSelected = argSel;
  }

  toggleselectprice(menu:Menu):number{
    let totPrice:number;
    if(menu.qty>0){
      if(menu.isSelected == true) {
        totPrice = +(menu.qty* +(menu.price));
      
        console.log(totPrice);
        this.totalOrderPrice =+ (totPrice);
        console.log(this.totalOrderPrice); 
      }
      return totPrice;
    }
    return 0;
  }
 // showingTotalPrice():number{
    //let price:number;
   // price = this.toggleselectprice(this.menu)
   // this.totalOrderPrice =+ (price);
   // return this.totalOrderPrice;
 // }
 

  toggleselectcalories(menu:Menu):number{
   let totCal:number;
    if(menu.qty>0){
      if(menu.isSelected == true) {
        totCal = +(menu.qty) * +(menu.foodCal);
        this.totalOrderCal =+ (totCal);
        console.log(totCal);
        this.totalOrderCal =+ (totCal);
        console.log(this.totalOrderCal); 
      }
      return totCal;
      
    }
    return 0;
    
  }
  //this.totalOrderCal = this.toggleselectcalories(this.menu)

  addOrder()
  {
    let menu:Menu;
    for (menu of this.menus){
    if(menu.isSelected == true) {
      this.fId= menu.foodId;
      this.cid=localStorage.getItem('custId');
      this.cwallet=localStorage.getItem('cwallet');
      this.qty=menu.qty;
      

      this.addOrderByRest(this.cid, this.fId,this.qty,this.cwallet);
     
    }
  }
  }
  addOrderByRest(cid,fid,qty,cwallet) {
    if(cid>=1) {
      if(this.totalOrderPrice < cwallet){
    let today : Date = new Date();
    let cid1 = localStorage.getItem('custId');
    console.log('Placing Order' + fid +  ' qty ' + qty);
    let or: Orders = new Orders(0,cid,0,fid,qty,0,0,"PLACE_ORDER","00:00:00","00:00:00",today," ");
    this.orderService.postOrderData(or,cid1)
    .subscribe(
      data => {
        this.poststr = data;
        console.log("post success",data);
        this.postS = true;
        alert("Order Placed Successfully!!!");
      },
      error => {
        console.log("Error",error);
        alert("Error occurred while placing order.. Retry!!!");
      }
    );
  }
  else {
    alert("Insufficient Balance");
  }
  }
  else {
    alert("Invalid Quantity");
  }
}
myFunction() {
  location.reload();

 }
 
  trackByFn(index:Number,menu:Menu){
    return menu;
  }

}

