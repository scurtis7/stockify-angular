import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock';
import { ActivatedRoute } from '@angular/router';
import { StockService } from '../stock.service';

@Component({
  selector: 'app-stock-search',
  templateUrl: './stock-search.component.html',
  styleUrls: ['./stock-search.component.css']
})
export class StockSearchComponent implements OnInit {
  stocks: Stock[] = [];

  constructor(
    private route: ActivatedRoute,
    private stockService: StockService
  ) { }

  ngOnInit(): void {
    // For testing purposes
    // this.stocks = [
    //   {"symbol":"AAPL", "name":"This is a small name", "currency":"currency", "timezone":"timezone", "region":"region", "type":"type"},
    //   {"symbol":"BA", "name":"This is a medium level name", "currency":"currency", "timezone":"timezone", "region":"region", "type":"type"},
    //   {"symbol":"BAC", "name":"This is a large name to test large names", "currency":"currency", "timezone":"timezone", "region":"region", "type":"type"},
    //   {"symbol":"MA", "name":"This is a very large name to test what happens with large names going even larger and even larger", "currency":"currency", "timezone":"timezone", "region":"region", "type":"type"}
    // ]
  }

  search(searchValue: string) {
    console.log(searchValue);
    this.stockService.stockSearch(searchValue)
      .subscribe(results => this.stocks = results);
  }

}
