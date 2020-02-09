import { Customer } from './customer';
import { Address } from './address';

export interface Order {
  id: number;
  customer: Customer;
  address: Address;
  destination: Address;
  service: string;
  date: Date;
}
