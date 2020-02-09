import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../model/customer';
import {Order} from '../model/order';
import {OrderService} from '../service/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  customerOrders: Order[];
  selectedOrder: Order = {id: -1, customer: null, address: null, destination: null, service: 'MOVING', date: new Date()};

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders() {
    this.orderService.getOrders().then((order: Order[]) => {
      this.customerOrders = order;
      console.log(order);
    }).catch(e => {
      console.log('Exception while getting customers orders!', e);
    });
  }

  orderClicked(event: Order) {
    this.selectedOrder = event;
  }
}
