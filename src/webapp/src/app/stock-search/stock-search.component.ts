import { Component, OnInit } from '@angular/core';
import { Stock } from "../stock";

@Component({
  selector: 'app-stock-search',
  templateUrl: './stock-search.component.html',
  styleUrls: ['./stock-search.component.css']
})
export class StockSearchComponent implements OnInit {
  stocks: Stock[] = [];

  constructor() { }

  ngOnInit(): void {
    // this.stocks = [
    //   {symbol: 'AAPL', name: 'Apple', type: 'Stock', currency: '$', timezone: 'EST', region: 'USA'},
    //   {symbol: 'MA', name: 'Mastercard', type: 'Stock', currency: '$', timezone: 'EST', region: 'USA'},
    //   {symbol: 'MSFT', name: 'Microsoft', type: 'Stock', currency: '$', timezone: 'EST', region: 'USA'},
    //   {symbol: 'WMT', name: 'Walmart', type: 'Stock', currency: '$', timezone: 'EST', region: 'USA'},
    //   {symbol: 'ZNGA', name: 'Zynga', type: 'Stock', currency: '$', timezone: 'EST', region: 'USA'},
    //   {symbol: 'SBUX', name: 'Starbucks', type: 'Stock', currency: '$', timezone: 'EST', region: 'USA'}
    // ];
  }

  search(searchValue: string) {
    console.log(searchValue);
  }

}
