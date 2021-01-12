import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreateEditContactsComponent } from './contacts/create-edit/create-edit.component';
import { ListContactsComponent } from './contacts/list/list.component';
import { CreateEditUsersComponent } from './users/create-edit/create-edit.component';
import { ListUsersComponent } from './users/list/list.component';
import { LoginComponent } from './login/login.component';
import { Erro404Component } from './sharedComponents/erro404/erro404.component';
import { NavigationBarComponent } from './sharedComponents/navigation-bar/navigation-bar.component';

import {MatIconModule} from '@angular/material/icon';

@NgModule({
  declarations: [
    AppComponent,
    CreateEditContactsComponent,
    ListContactsComponent,
    CreateEditUsersComponent,
    ListUsersComponent,
    LoginComponent,
    Erro404Component,
    NavigationBarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
