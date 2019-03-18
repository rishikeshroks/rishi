import { Injectable } from '@angular/core';
import { Orders } from './orders';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable()
export class OrdersServiceService {
   posturl = "http://localhost:8080/FTP107/api/customer/placeorder/3";
   puturl = "http://localhost:8080/FTP107/api/orders/update/113";

  constructor(private httpClient: HttpClient) { }
  getvendororderhistory(vid:string): Observable<Orders[]> {
    let url = "http://localhost:8080/FTP107/api/orders/ven/"+ vid;
    return this.httpClient.get<Orders[]>(url);
  }
  getplacedorder(venId:any): Observable<Orders[]> {
    let url = "http://localhost:8080/FTP107/api/orders/placed/"+ venId;
    return this.httpClient.get<Orders[]>(url);
  }
  getcustomerordershistory(cid:string): Observable<Orders[]> {
    let url = "http://localhost:8080/FTP107/api/orders/cust/"+ cid;
    return this.httpClient.get<Orders[]>(url);
  }
  putOrderData(ord:Orders, oId:any) : Observable<Orders[]> {
    let url = "http://localhost:8080/FTP107/api/orders/update/"+ oId;
    return this.httpClient.put<Orders[]>(url,ord);
  }
  postOrderData(or:Orders,cid:string): Observable<any> {
    
    console.log('Placing Order cc ' +cid );
    let url = "http://localhost:8080/FTP107/api/customer/placeorder/"+cid;
    return this.httpClient.post(url,or);
}
public ordArr : Orders[];


getOrders(): Orders[] {
 return this.ordArr;
}
AddOrder(ord: Orders):void{
this.ordArr.push(ord);
}
}
