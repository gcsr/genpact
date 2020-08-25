import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../model/user';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ResetPassword } from '../model/ResetPassword';
import { Config } from 'protractor';
import { LibraryCard } from '../model/library-card';

@Injectable({
    providedIn: 'root'
})
export class LibraryService {


    constructor(private http: HttpClient) {
    }


    getLibraries() {
        return this.http.get<LibraryCard[]>(
            `${environment.apiUrl}/library`);
    }


    
}
