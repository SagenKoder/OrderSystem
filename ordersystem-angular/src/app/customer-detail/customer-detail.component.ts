import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  @Input() customer: Customer;
  @Input() showCustomerOrder: boolean;
  @Output() cancelEvent = new EventEmitter<Customer>();
  @Output() saveEvent = new EventEmitter<Customer>();
  @Output() toggleOrdersEvent = new EventEmitter<boolean>();

  constructor() {}

  ngOnInit(): void {
  }

  cancelDetails(customer: Customer) {
    this.cancelEvent.emit(customer);
  }

  saveDetails(customer: Customer) {
    this.saveEvent.emit(customer);
  }

  showCustomersOrder() {
    this.toggleOrdersEvent.emit();
  }
}
