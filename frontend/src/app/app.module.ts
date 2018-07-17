import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import {BnkseekListComponent} from './components/bnkseek-list/bnkseek-list.component';
import {BnkseeEditModalComponent} from './components/bnksee-edit-modal/bnksee-edit-modal.component';
import {BnkseeRemoveModalComponent} from './components/bnksee-remove-modal/bnksee-remove-modal.component';
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule} from "@angular/forms";

import {BnkSeekService} from "./services/bnk-seek.service";
import {UploadFileComponent} from './components/upload-file/upload-file.component';


@NgModule({
  declarations: [
    AppComponent,
    BnkseekListComponent,
    BnkseeEditModalComponent,
    BnkseeRemoveModalComponent,
    UploadFileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [BnkSeekService],
  bootstrap: [AppComponent]
})
export class AppModule { }
