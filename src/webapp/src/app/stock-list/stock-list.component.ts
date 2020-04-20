import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock';
import { STOCKS } from '../mock-stocks';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {

  stocks = STOCKS;

  constructor() { }

  ngOnInit(): void {
  }

  delete(stock: Stock) {
    console.log(stock.name);
  }

}
