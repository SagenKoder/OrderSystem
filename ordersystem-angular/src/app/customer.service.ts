import { Injectable } from '@angular/core';
import { Customer } from './customer';
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

  getCustomerById(customerId) {
    return this.http.get<Customer>(
      this.url + customerId,
      { observe: 'response' }
    ).toPromise();
  }

  createCustomer(customer) {
    return this.http.post<Customer>(
      this.url,
      customer,
      { observe: 'response' }
    ).toPromise();
  }

  updateCustomer(customer, customerId) {
    return this.http.put<Customer>(
      this.url + customerId,
      customer,
      { observe: 'response' }
    ).toPromise();
  }

  deleteCustomer(customerId) {
    return this.http.delete<Customer>(
      this.url + customerId,
      { observe: 'response' }
    ).toPromise();
  }
}
