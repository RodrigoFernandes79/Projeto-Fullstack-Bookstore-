import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { FooterComponent } from './components/template/footer/footer.component';
import { SidenavComponent } from './components/template/sidenav/sidenav.component'
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './components/views/home/home.component';
import { CategoriaListComponent } from './components/views/categoria/categoria-list/categoria-list.component';
import {MatTableModule} from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';

import { ToastrModule } from 'ngx-toastr';

import { RouterModule } from '@angular/router';
import { CategoriaCreateComponent } from './components/views/categoria/categoria-create/categoria-create.component';
import { FormsModule } from '@angular/forms';
import { CategoriaUpdateComponent } from './components/views/categoria/categoria-update/categoria-update.component';
import { LivroListComponent } from './components/views/livro/livro-list/livro-list.component';











@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SidenavComponent,
    HomeComponent,
    CategoriaListComponent,
    CategoriaCreateComponent,
    CategoriaUpdateComponent,
    LivroListComponent,
  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatTableModule,
    HttpClientModule,
    RouterModule,
    ToastrModule,
    FormsModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
