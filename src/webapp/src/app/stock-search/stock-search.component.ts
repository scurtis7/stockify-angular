import { Component, OnInit } from '@angular/core';
import { Stock } from "../stock";
import { ActivatedRoute } from "@angular/router";
import { StockService } from "../stock.service";

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
  }

  search(searchValue: string) {
    console.log(searchValue);
    this.stockService.stockSearch(searchValue)
      .subscribe(results => this.stocks = results);
  }

}
