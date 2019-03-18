import { Injectable } from '@angular/core';
import { Vendor } from './vendor';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendorService {
  logVenArr: Vendor[];

  constructor(
    private httpClient: HttpClient) {}
  
    verifyUNamePassword(venUsername:string, venPassword:string) : Observable<Vendor> {
    console.log('verifyunamepassword');
    const params = new HttpParams()
  .set('venUsername',venUsername)
  .set('venPassword',venPassword);
  console.log(params.toString());
    return this.httpClient.get<Vendor>('http://localhost:8080/FTP107/api/vendor/vlogin',{params});

 }


  public validateLogin( argVenlog:Vendor): Vendor{
    console.log(argVenlog);
    for(let mylog of this.logVenArr ){
      console.log("in array"+ mylog.venUsername + " " + mylog.venPassword);
      let c =mylog.venUsername;
      if (mylog.venUsername == argVenlog.venUsername &&
       mylog.venPassword == argVenlog.venPassword) {
         console.log(" true");
       return mylog;
       }
    }
  }
  getVendorDetails(vid: string) : Observable<any> {
    let url = "http://localhost:8080/FTP107/api/vendor/vendordetails/" +vid;
    console.log('getVendorDetails : ' + url );
    return this.httpClient.get<any>(url);
}

}
