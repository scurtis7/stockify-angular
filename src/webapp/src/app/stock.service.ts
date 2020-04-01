import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { catchError, map } from "rxjs/operators";
import { Stockquote } from "./stockquote";
import { Stock } from "./stock";

@Injectable({
  providedIn: 'root'
})
export class StockService {

  private baseUrl = 'alpha';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient
  ) { }

  getStockQuote(symbol: string): Observable<Stockquote> {
    const url = `${this.baseUrl}/quote/${symbol}`;
    return this.http.get<Stockquote>(url).pipe(
      catchError(this.handleError<Stockquote>(`getStockQuote symbol = ${symbol}`))
    );
  }

  stockSearch(symbol: string): Observable<Stock[]> {
    const url = `${this.baseUrl}/search/${symbol}`;
    return this.http.get<Stock[]>(url).pipe(
      catchError(this.handleError<Stock[]>(`stockSearch symbol = ${symbol}`))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


}
