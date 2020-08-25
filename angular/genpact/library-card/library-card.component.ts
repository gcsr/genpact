import { Component, OnInit, Input } from '@angular/core';
import { BookCard } from 'src/app/model/book-card';
import { Router, NavigationExtras } from '@angular/router';
import { LibraryCard } from 'src/app/model/library-card';

@Component({
  selector: 'app-library-card',
  templateUrl: './library-card.component.html',
  styleUrls: ['./library-card.component.scss']
})
export class LibraryCardComponent implements OnInit {

  @Input() library:LibraryCard;
  constructor(private router: Router) { }

  ngOnInit() {
    console.log("*******************",JSON.stringify(this.library));
  }
  onLibrarySelect() {
    this.router.navigate(['book'], {queryParams: {allBooks: JSON.stringify(this.library.books) }});
   
  }


}
