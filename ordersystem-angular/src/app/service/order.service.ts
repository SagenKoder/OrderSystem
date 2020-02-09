import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../model/customer';
import {Order} from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private url = 'http://localhost:8080/order/';

  constructor(private http: HttpClient) { }

  getOrdersByCustomer(customerId: number) {
    return this.http.get<Order[]>(
      this.url + 'customer/' + customerId
    ).toPromise();
  }

  getOrders() {
    return this.http.get<Order[]>(
      this.url
    ).toPromise();
  }

}
