import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustloginComponent } from 'src/app/custlogin/custlogin.component';
import { Menu } from 'src/app/menu';
import { HomeComponent } from 'src/app/home/home.component';
import { VendorloginComponent } from 'src/app/vendorlogin/vendorlogin.component';
import { VendoracceptdenyComponent } from 'src/app/vendoracceptdeny/vendoracceptdeny.component';
import { VendororderhistoryComponent } from 'src/app/vendororderhistory/vendororderhistory.component';
import { VendordashboardComponent } from 'src/app/vendordashboard/vendordashboard.component';
import { CustdashboardComponent } from 'src/app/custdashboard/custdashboard.component';
import { CustorderhistoryComponent } from 'src/app/custorderhistory/custorderhistory.component';
import { CustplaceorderComponent } from 'src/app/custplaceorder/custplaceorder.component';

import { CustomerwalletComponent } from 'src/app/customerwallet/customerwallet.component';
import { CustdashhomeComponent } from 'src/app/custdashhome/custdashhome.component';
import { VendashhomeComponent } from 'src/app/vendashhome/vendashhome.component';
export const vendorCHILD_ROUTES:Routes=[
  {path: 'vendororderhistory',component:VendororderhistoryComponent},
{ path: 'vendoracceptdeny',component:VendoracceptdenyComponent},
{path:'home', component:VendashhomeComponent},
{path:'', redirectTo:'home', pathMatch:'full'}
];

export const customerCHILD_ROUTES:Routes=[
  {path:'customerorderhistory',component:CustorderhistoryComponent},
    {path:'placeorder',component:CustplaceorderComponent},
    {path:'showwallet',component:CustomerwalletComponent},
    {path:'home', component:CustdashhomeComponent},
    {path:'', redirectTo:'home', pathMatch:'full'}
  ];
const routes: Routes = [
  {path: 'vendordashboard/:vid',component:VendordashboardComponent,children:vendorCHILD_ROUTES},
  {path: 'customerdashboard/:cid',component:CustdashboardComponent,children:customerCHILD_ROUTES},
  {path:'custlogin', component:CustloginComponent},
  {path:'vendorlogin', component:VendorloginComponent},
 
  {path:'home', component:HomeComponent},
  {path:'', redirectTo:'/home', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
