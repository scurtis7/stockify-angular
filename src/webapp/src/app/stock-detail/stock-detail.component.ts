import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { Stock } from "../stock";
import { StockService } from "../stock.service";

@Component({
  selector: 'app-stock-detail',
  templateUrl: './stock-detail.component.html',
  styleUrls: ['./stock-detail.component.css']
})
export class StockDetailComponent implements OnInit {
  @Input() stock: Stock;

  constructor(
    private route: ActivatedRoute,
    private stockService: StockService
  ) { }

  ngOnInit(): void {
    this.getStock();
  }

  getStock(): void {
    const symbol = this.route.snapshot.paramMap.get('symbol');
    this.stockService.getStock(symbol)
      .subscribe(stock => this.stock = stock);
  }

}
