import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FileUploadComponent } from './components/file-upload/file-upload.component';
// import { MatButtonModule } from '@angular/material/button'
import { FormsModule } from '@angular/forms';
// import {BrowserAnimationsModule} from '@angular/platform browser/animations';
import { HttpClientModule } from '@angular/common/http'
import { CommonModule } from '@angular/common';  



@NgModule({
  declarations: [
    AppComponent,
    FileUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [FileUploadComponent]
})
export class AppModule { }
