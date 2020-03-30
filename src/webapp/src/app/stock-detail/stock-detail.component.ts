import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { StockService } from "../stock.service";
import {Stockquote} from "../stockquote";

@Component({
  selector: 'app-stock-detail',
  templateUrl: './stock-detail.component.html',
  styleUrls: ['./stock-detail.component.css']
})
export class StockDetailComponent implements OnInit {
  @Input() stockQuote: Stockquote;

  constructor(
    private route: ActivatedRoute,
    private stockService: StockService
  ) { }

  ngOnInit(): void {
    this.getStockQuote();
  }

  getStockQuote(): void {
    const symbol = this.route.snapshot.paramMap.get('symbol');
    this.stockService.getStockQuote(symbol)
      .subscribe(stockQuote => this.stockQuote = stockQuote);
  }

}
