import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-et-list',
  templateUrl: './et-list.component.html',
  styleUrls: ['./et-list.component.css']
})
export class EtListComponent implements OnInit {

  expenses: any;

  constructor(private httpClient: HttpClient) {
    this.expenses = [];
  }

  ngOnInit(): void {
    this.httpClient.get<Object>('http://localhost:8080/api/expenses').subscribe(
      data => {
        this.expenses = data;
        console.log(this.expenses);
      }
    )
  }

}
