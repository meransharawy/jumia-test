import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Customer } from './Customer';
import { Observable } from 'rxjs';
import { Form } from '@angular/forms';
import { FilterationModel } from './filteration-model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private getAllCustomersUrl: string;
  private getFilteredCustomersUrl: string;
  private getAllCountriesUrl: string;

  constructor(private http: HttpClient) {
    this.getAllCustomersUrl = 'http://localhost:8181/customers';
    this.getFilteredCustomersUrl = 'http://localhost:8181/customers/filter';
    this.getAllCountriesUrl='http://localhost:8181/countries';
  }

  public getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.getAllCustomersUrl);
  }

  public getFilteredCustomers(filterationData:FilterationModel): Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    return this.http.post(this.getFilteredCustomersUrl, filterationData,{'headers':headers});
  }

  public getAllCountries(): Observable<String[]> {
    return this.http.get<String[]>(this.getAllCountriesUrl);
  }

}
