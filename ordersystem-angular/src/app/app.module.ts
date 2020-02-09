import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CustomersComponent } from './customers/customers.component';
import { FormsModule } from '@angular/forms';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { RouterModule, Routes } from '@angular/router';
import { OrdersComponent } from './orders/orders.component';
import { OrdersListComponent } from './orders-list/orders-list.component';
import { OrderDetailComponent } from './order-detail/order-detail.component';

const appRoutes: Routes = [
  {
    path: 'customer',
    component: CustomersComponent
  },
  {
    path: 'order',
    component: OrdersComponent
  },
  {
    path: '',
    redirectTo: '/order',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    CustomersComponent,
    CustomerDetailComponent,
    OrdersComponent,
    OrdersListComponent,
    OrderDetailComponent
  ],
    imports: [
        RouterModule.forRoot(
          appRoutes,
          { enableTracing: true }
        ),
        BrowserModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
