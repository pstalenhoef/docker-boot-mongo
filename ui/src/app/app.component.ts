import { Component, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/finally';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  @Input()
  searchTerm: string;

  // Store token, to communicate with the server
  access: Access;

  // Booleans to determine which parts of the UI should be shown
  authenticated = false;
  results = false;
  selected = false;

  // URL's should move to configuration
  url_auth = 'https://localhost:9443/auth/oauth/token?grant_type=password&scope=webclient&username=paul.stalenhoef&password=password1';
  url_search = 'https://localhost:8443/searchservice/api/v1/search/';

  pageNr = 1;
  currentPage: number;
  numberOfPages: number;
  addressList: Address[];
  entry: Address;

  headerDict = {
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
    'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
    'Authorization': 'Basic Y29pbmNsaWVudDpjb2luc2VjcmV0'
  };

  requestOptions = {
    headers: new HttpHeaders(this.headerDict),
  };

  constructor(private http: HttpClient) {
    this.authenticate();
  }

  authenticate() {
    this.http.post(this.url_auth, null, this.requestOptions).subscribe((data: Access) => { this.access = {
        access_token: data['access_token'],
        token_type: data['token_type'],
        refresh_token: data['refresh_token'],
        expires_in: data['expires_in'],
        scope: data['scope']
      };
      this.authenticated = true;
    });
  }
  logout() {
      this.http.post('logout', {}).finally(() => {
          this.authenticated = false;
      }).subscribe();
  }

  public search() {
    this.pageNr = 1;
    this.getResults();
  }

  public nextPage() {
    this.pageNr = this.pageNr + 1;
    this.getResults();
  }

  public previousPage() {
    this.pageNr = this.pageNr - 1;
    this.getResults();
  }

  private getResults() {
    const url = this.url_search + this.searchTerm + '/' + this.pageNr;
    this.results = false;
    this.selected = false;

    // tslint:disable-next-line:max-line-length
    const headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer ' + this.access.access_token});
    const options = { headers: headers };

    this.http.get(url, options).subscribe((searchResult: SearchResult) => {
      this.currentPage = searchResult['currentPage'];
      this.numberOfPages = searchResult['numberOfPages'];
      this.addressList = searchResult['addressList'];
      this.results = true;
    });

    console.log('Searching');
  }

  public showDetails(event: number) {
    this.selected = true;
    this.entry = this.addressList[event];
  }
}

export interface Access {
  access_token: string;
  token_type: string;
  refresh_token: string;
  expires_in: string;
  scope: string;
}

export interface SearchResult {
  currentpage: number;
  numberOfPages: number;
  addressList: Address[];
}

export interface Address {
  id: string;
  companyName: string;
  firstName: string;
  lastName: string;
  address: string;
  phoneNumber: string;
  gender: string;
}
