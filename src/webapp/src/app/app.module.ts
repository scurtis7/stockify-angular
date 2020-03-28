import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { StockListComponent } from './stock-list/stock-list.component';
import { StockSearchComponent } from './stock-search/stock-search.component';

@NgModule({
  declarations: [
    AppComponent,
    StockListComponent,
    StockSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
