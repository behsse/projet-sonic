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
import { CatalogueComponent } from './pages/catalogue/catalogue.component';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListeThemeComponent } from './pages/catalogue/liste-theme/liste-theme.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { DashboardPageComponent } from './pages/dashboard/dashboard-page/dashboard-page.component';
import { FormsFormationComponent } from './pages/dashboard/dashboard-page/forms-formation/forms-formation.component';
import { FormsFormationUpdateComponent } from './pages/dashboard/dashboard-page/forms-formation-update/forms-formation-update.component';
import { FormationDetailsComponent } from './pages/dashboard/dashboard-page/formation-details/formation-details.component';
import { FormationComposantsComponent } from './pages/dashboard/dashboard-page/formation-composants/formation-composants.component';
import { ContactComponent } from './pages/contact/contact.component';
import { CardFormationhomeComponent } from './pages/home/card-formationhome/card-formationhome.component';
import { InscriptionSessionComponent } from './pages/inscription-session/inscription-session.component';

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
    CatalogueComponent,
    ListeThemeComponent,
    DashboardComponent,
    DashboardPageComponent,
    FormsFormationComponent,
    FormsFormationUpdateComponent,
    FormationDetailsComponent,
    FormationComposantsComponent,
    ContactComponent,
    CardFormationhomeComponent,
    ContactComponent,
    InscriptionSessionComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatSelectModule,
    MatCardModule,
    LottieAnimationViewModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
