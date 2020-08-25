import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../model/user';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ResetPassword } from '../model/ResetPassword';
import { Config } from 'protractor';
import { BookCard } from '../model/book-card';

@Injectable({
    providedIn: 'root'
})
export class BookService {


    constructor(private http: HttpClient) {
    }


    getBooks() {
        return this.http.get(
            `${environment.apiUrl}/book`);
    }
}
