import {Component, Input, OnInit} from '@angular/core';
import {Order} from '../model/order';
import {Customer} from '../model/customer';

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent implements OnInit {

  @Input() orders: Order[];
  @Input() customer: Customer;

  selectedOrder = false;

  constructor() { }

  ngOnInit(): void {
  }

  onSelect(order: Order) {
    console.log('Selected order ' + order);
  }
}
