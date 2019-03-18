import { Component, OnInit } from '@angular/core';
//import { Router } from '@angular/router';

@Component({
  selector: 'app-custdashboard',
  templateUrl: './custdashboard.component.html',
  styleUrls: ['./custdashboard.component.css']
})
export class CustdashboardComponent implements OnInit {
  
  constructor() { }
  ngOnInit() {
  }

/*  commented by radha
  gotoPlaceOrder():void{
    this._router.navigate(['/placeorder'])
  }
*/

  // customerorderhistory():void{
  //   this._router.navigate(['/customerorderhistory/:cid']);
  //   console.log("customer's ordershistory is clicked");
  // }
//   placeorder():void{
//     this._router.navigate(['/placeorder/:cid']),
//     console.log("placing the orders");
//   }
//   showwallet():void{
//     this._router.navigate(['/showwalletdetails/:cid']);
//     console.log("show the wallet details");
//   }
// 
}