import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule  } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MenuServiceService } from 'src/app/menu.service';
import { CustloginComponent } from './custlogin/custlogin.component';
import { VendorloginComponent } from './vendorlogin/vendorlogin.component';
import { CustdashboardComponent } from './custdashboard/custdashboard.component';
import { VendordashboardComponent } from './vendordashboard/vendordashboard.component';
import { CustorderhistoryComponent } from './custorderhistory/custorderhistory.component';
import { CustplaceorderComponent } from './custplaceorder/custplaceorder.component';
import { VendororderhistoryComponent } from './vendororderhistory/vendororderhistory.component';
import { VendoracceptdenyComponent } from './vendoracceptdeny/vendoracceptdeny.component';
import { CustomerwalletComponent } from './customerwallet/customerwallet.component';
import { CustdashhomeComponent } from './custdashhome/custdashhome.component';
import { VendashhomeComponent } from './vendashhome/vendashhome.component';

const routes:Routes=[
    {path:'', component:HomeComponent},
  ];
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CustloginComponent,
    VendorloginComponent,
    CustdashboardComponent,
    VendordashboardComponent,
    CustorderhistoryComponent,
    CustplaceorderComponent,
    VendororderhistoryComponent,
    VendoracceptdenyComponent,
    VendororderhistoryComponent,
    CustomerwalletComponent,

    CustdashhomeComponent,
    VendashhomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [MenuServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
