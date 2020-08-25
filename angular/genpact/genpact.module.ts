import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookComponent } from './book/book.component';
import { LibraryComponent } from './library/library.component';
import { LibraryCardComponent } from './library-card/library-card.component';
import { BookCardComponent } from './book-card/book-card.component';
import { AppCommonModule } from '../app-common/app-common.module';
import { MDBBootstrapModulesPro } from 'ng-uikit-pro-standard';



@NgModule({
  declarations: [BookComponent, LibraryComponent, LibraryCardComponent, BookCardComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    MDBBootstrapModulesPro.forRoot()
  ],
  exports:[BookComponent,LibraryComponent]
})
export class GenpactModule { }
