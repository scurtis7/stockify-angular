import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from "./about/about.component";
import {SigninComponent} from "./signin/signin.component";
import {StocksComponent} from "./stocks/stocks.component";
import {SearchComponent} from "./search/search.component";

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'stocks', component: StocksComponent },
  { path: '#', component: StocksComponent },
  { path: '', component: StocksComponent },
  { path: 'search', component: SearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
