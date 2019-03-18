import { Injectable } from '@angular/core';
import { Customer } from 'src/app/customer';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn : 'root'
})
export class custLoginService {
  constructor(private httpClient: HttpClient) {}

   public validateCustLogin(cUserName:string, cPassword:string):Observable<Customer> {
     const params = new HttpParams()
     .set('cUserName',cUserName)
     .set('cPassword',cPassword);
     console.log(params.toString());
     return this.httpClient.get<Customer>
     ('http://localhost:8080/FTP107/api/customer/clogin?', {params});
   }
   showwallet(cid: string) : Observable<any> {
    let url = "http://localhost:8080/FTP107/api/customer/showwallet/" +cid;
    console.log('showwallet : ' + url );
    return this.httpClient.get<any>(url);
}


}
