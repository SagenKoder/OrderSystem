import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Customer } from '../customer';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  @Input() customer: Customer;
  @Output() cancelEvent = new EventEmitter<Customer>();
  @Output() saveEvent = new EventEmitter<Customer>();

  constructor() { }

  ngOnInit(): void {
  }

  cancelDetails(customer: Customer) {
    this.cancelEvent.emit(customer);
  }

  saveDetails(customer: Customer) {
    this.saveEvent.emit(customer);
  }
}
