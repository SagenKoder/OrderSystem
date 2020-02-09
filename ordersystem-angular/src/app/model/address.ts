import {PostNummer} from './postnummer';

export interface Address {
  line1: string;
  line2: string;
  zip: PostNummer;
}
