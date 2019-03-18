import { TestBed } from '@angular/core/testing';
import {HttpClientTestingModule,HttpTestingController} from '@angular/common/http/testing';
import { MenuServiceService } from './menu.service';
import { Menu } from './menu';

describe('MenuServiceService', () => {
  let httpMock :HttpTestingController;
  let service : MenuServiceService;
//   beforeEach(() => TestBed.configureTestingModule({}));

//   it('should be created', () => {
//     const service: MenuServiceService = TestBed.get(MenuServiceService);
//     expect(service).toBeTruthy();
//   });
// });
beforeEach(() => { 
  TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule
    ],
    providers:[MenuServiceService]
  });          
  service = TestBed.get(MenuServiceService);
  httpMock = TestBed.get(HttpTestingController);
});

it('based on menu service - sample http mocking',()=>{
const menus: Menu[]= [new Menu(1002,'Chicken Biryani',100,'Biryani','1 plate',78.0,502)];
service.getMenu().subscribe(
(data) => {
expect(data.length).toBe(1);
expect(data).toEqual(menus);
});
let myurl ="http://localhost:8080/FTP107/api/menu"
const request = httpMock.expectOne(myurl);
expect(request.request.method).toBe('GET');
request.flush(menus);

});
afterEach(() => { 
httpMock.verify();
});

});
