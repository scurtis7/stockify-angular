import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { catchError, map } from "rxjs/operators";
import {Stockquote} from "./stockquote";

@Injectable({
  providedIn: 'root'
})
export class StockService {

  private baseUrl = 'alpha/quote';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient
  ) { }

  getStockQuote(symbol: string): Observable<Stockquote> {
    const url = `${this.baseUrl}/${symbol}`;
    return this.http.get<Stockquote>(url).pipe(
      catchError(this.handleError<Stockquote>(`getStockQuote symbol = ${symbol}`))
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
