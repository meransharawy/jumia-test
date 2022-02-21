import { Component } from '@angular/core';
import { Customer } from '../app/Customer';
import { FilterationModel } from '../app/filteration-model';
import { CustomerService } from '../app/customer-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;
  customers: Customer[];
  countries: String[];
  filterationModel= new FilterationModel();

  constructor(private customerService: CustomerService) {
    this.title = 'Phone Numbers Identifier';
  }


  ngOnInit() {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customers = data;
    });

    this.customerService.getAllCountries().subscribe(data => {
      this.countries = data;
    });

  }

  onSubmit(){
    this.customerService.getFilteredCustomers(this.filterationModel).subscribe(data => {
      this.customers = data;
    });
  }




}