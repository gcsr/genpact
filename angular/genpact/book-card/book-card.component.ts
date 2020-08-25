import { Component, OnInit, Input } from '@angular/core';
import { BookCard } from 'src/app/model/book-card';
import { Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.scss']
})
export class BookCardComponent implements OnInit {

  @Input() book:BookCard;
  constructor(private router: Router) { }

  ngOnInit() {
  }
  onBookSelect() {
    
    
  }

}
