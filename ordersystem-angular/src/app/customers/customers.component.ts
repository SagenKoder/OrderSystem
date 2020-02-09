import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';
import {OrderService} from '../service/order.service';
import {Order} from '../model/order';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  searchText: string;
  showCustomerOrder = false;
  customerOrders: Order[];

  selectedCustomer = {
    id: -1,
    name: '',
    phone: '',
    email: ''
  };
  customers: Customer[];

  constructor(private customerService: CustomerService, private orderService: OrderService) {
  }

  saveDetail(customer: Customer) {
    this.saveCustomer(customer);
    console.log('Saved customer ' + customer);
  }

  cancelDetail(customer: Customer) {
    this.showCustomerOrder = false;
    this.customerOrders = null;
    this.selectedCustomer = {id: -1, name: '', phone: '', email: ''};
  }

  showCustomersOrder() {
    this.showCustomerOrder = !this.showCustomerOrder;
  }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers(): void {
    this.customerService.getCustomers().then((customers: Customer[]) => {
      this.customers = customers;
    });
  }

  getCustomersFiltered(filter: string): void {
    this.customerService.getCustomersFiltered(filter).then((customers: Customer[]) => {
      this.customers = customers;
    });
  }

  getOrdersByCustomer(customerId: number) {
    this.orderService.getOrdersByCustomer(customerId).then((order: Order[]) => {
      this.customerOrders = order;
      console.log(order);
    }).catch(e => {
      console.log('Exception while getting customers orders!', e);
    });
  }

  saveCustomer(customer: Customer) {
    if (customer.id <= 0) {
      this.customerService.createCustomer(customer)
          .then(r => {
            console.log('Created customer ' + customer);
            this.selectedCustomer = customer;
          })
          .catch(e => {
            console.log('Exception while creating new user! ' + e);
          });
    } else {
      this.customerService.updateCustomer(customer, customer.id)
          .then(r => {
            console.log('Updated customer ' + customer);
            this.selectedCustomer = customer;
          })
          .catch(e => {
            console.log('Exception while updating user! ' + e);
          });
    }
    this.search(this.searchText);
  }

  onSelect(customer: Customer) {
    this.selectedCustomer = customer;
    this.showCustomerOrder = false;
    this.getOrdersByCustomer(this.selectedCustomer.id);
  }

  search(event: string) {
     this.searchText = event;
     if (event.length === 0) { this.getCustomers(); } else { this.getCustomersFiltered(event); }
  }
}
