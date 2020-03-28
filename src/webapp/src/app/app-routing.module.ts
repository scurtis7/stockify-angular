import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StockListComponent } from './stock-list/stock-list.component';
import { StockSearchComponent } from "./stock-search/stock-search.component";

const routes: Routes = [
  { path: 'stocklist', component: StockListComponent },
  { path: 'stocksearch', component: StockSearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
