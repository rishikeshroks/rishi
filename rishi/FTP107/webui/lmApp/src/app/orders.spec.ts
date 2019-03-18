import { Orders } from './orders';

let str1 : string= "2019-03-12 18:25:49";
let date1 = new Date(str1);


describe('Orders', () => {
  it('should create an instance', () => {
    expect(new Orders(113, 1, 500, 1000, 2, 40, 90, 'DELIVERED', '18:25:49', '18:25:49', date1, 'Thank you for Ordering')).toBeTruthy();
  });
});
