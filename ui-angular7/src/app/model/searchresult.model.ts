import { Address } from './address.model';

export interface SearchResult {
  currentpage: number;
  numberOfPages: number;
  addressList: Address[];
}
