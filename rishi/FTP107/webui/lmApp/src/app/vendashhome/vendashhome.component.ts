import { Component, OnInit } from '@angular/core';
import { VendorService } from 'src/app/vendor.service';
import { Vendor } from 'src/app/vendor';

@Component({
  selector: 'app-vendashhome',
  templateUrl: './vendashhome.component.html',
  styleUrls: ['./vendashhome.component.css']
})
export class VendashhomeComponent implements OnInit {
  errorMsg:any;
myvendor:Vendor;
vid:string;
  constructor(private vendorservice:VendorService ) { }

  ngOnInit() {
    this.vid=localStorage.getItem('venId');
    console.log("localval"+this.vid);
    this.vendorservice.getVendorDetails(this.vid)
    .subscribe(
      data =>{
        this.myvendor = data ,
        console.log('data' + this.myvendor.venName);
  
    },
    error =>{
      this.errorMsg = error;
      console.log('error' + error);
    }
    );
  }

  }


  


