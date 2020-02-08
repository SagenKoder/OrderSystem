import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerDetailOrdersComponent } from './customer-detail-orders.component';

describe('CustomerDetailOrdersComponent', () => {
  let component: CustomerDetailOrdersComponent;
  let fixture: ComponentFixture<CustomerDetailOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerDetailOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerDetailOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
