import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import {LottieAnimationViewModule } from 'ng-lottie';

import { AppComponent } from './app.component';
import { NavbarComponent } from './_commons/navbar/navbar.component';
import { FooterComponent } from './_commons/footer/footer.component';
import { NotFoundComponent } from './_commons/not-found/not-found.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './pages/home/home.component';
import { FormationComponent } from './pages/formation/formation.component';
import { ThemeComponent } from './pages/theme/theme.component';
import { SousthemeComponent } from './pages/soustheme/soustheme.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    NotFoundComponent,
    HomeComponent,
    FormationComponent,
    ThemeComponent,
    SousthemeComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    LottieAnimationViewModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
