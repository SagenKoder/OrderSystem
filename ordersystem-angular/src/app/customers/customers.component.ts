import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  selectedCustomer: Customer;
  customers: Customer[];

  saveDetail(customer: Customer) {
    console.log(customer);
  }

  cancelDetail(customer: Customer) {
    this.selectedCustomer = null;
  }

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers(): void {
    this.customerService.getCustomers().then((customers: Customer[]) => {
      this.customers = customers;
    });
  }

  onSelect(customer: Customer) {
    this.selectedCustomer = customer;
  }
}
