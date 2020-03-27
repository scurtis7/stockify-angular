import { Component, OnInit } from '@angular/core';
import { Stock } from "../model/stock";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  stocks: Stock[];

  constructor() { }

  ngOnInit(): void {
    this.searchStocks();
  }

  public searchStocks() {
  }

}
