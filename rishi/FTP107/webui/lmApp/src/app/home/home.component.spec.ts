import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeComponent } from './home.component';
import { MenuServiceService } from '../menu.service';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { Menu } from '../menu';

describe('HomeComponent', () => {
  let httpClient: HttpClient;
  let service: MenuServiceService;
  let component: HomeComponent;
  //let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    //fixture = TestBed.createComponent(HomeComponent);
    //component = fixture.componentInstance;
    //fixture.detectChanges();
    service = new MenuServiceService(httpClient);
    component = new HomeComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it(' should call ngInit with success',() =>{
    let men =[new Menu(1002,'Chicken Biryani',100,'Biryani','1 plate',78.0,502)];
  //localStorage.setItem('cid','3')
  spyOn(service, 'getMenu').and.returnValue( of(men));
  component.ngOnInit();
  expect(component.menus).toEqual(men);
  expect(component.menus).not.toEqual(null);
  });
});
