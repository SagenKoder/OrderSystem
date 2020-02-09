import { Injectable } from '@angular/core';
import { Customer } from '../model/customer';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private url = 'http://localhost:8080/customer/';

  constructor(private http: HttpClient) { }

  getCustomers() {
    return this.http.get<Customer[]>(this.url).toPromise();
  }

  getCustomersFiltered(filter: string) {
    return this.http.get<Customer[]>(
      this.url + 'search/' + encodeURI(filter)
    ).toPromise();
  }

  getCustomerById(customerId: number) {
    return this.http.get<Customer>(
      this.url + customerId
    ).toPromise();
  }

  createCustomer(customer: Customer) {
    console.log('POST ' + this.url, customer);
    return this.http.post<Customer>(
      this.url,
      customer
    ).toPromise();
  }

  updateCustomer(customer: Customer, customerId: number) {
    console.log('PUT ' + this.url + customerId, customer);
    return this.http.put<Customer>(
      this.url + customerId,
      customer
    ).toPromise();
  }

  deleteCustomer(customerId: number) {
    return this.http.delete<Customer>(
      this.url + customerId
    ).toPromise();
  }
}
