import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../model/customer';

@Component({
  selector: 'app-customer-detail-orders',
  templateUrl: './customer-detail-orders.component.html',
  styleUrls: ['./customer-detail-orders.component.css']
})
export class CustomerDetailOrdersComponent implements OnInit {
  @Input() customer: Customer;

  constructor() { }

  ngOnInit(): void {
  }

}
