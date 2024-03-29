import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogueComponent } from './pages/catalogue/catalogue.component';
import { FormationDetailsComponent } from './pages/dashboard/dashboard-page/formation-details/formation-details.component';
import { FormsFormationUpdateComponent } from './pages/dashboard/dashboard-page/forms-formation-update/forms-formation-update.component';
import { FormsFormationComponent } from './pages/dashboard/dashboard-page/forms-formation/forms-formation.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ContactComponent } from './pages/contact/contact.component';
import { FormationComponent } from './pages/formation/formation.component';
import { ThemeComponent } from './pages/theme/theme.component';
import { NotFoundComponent } from './_commons/not-found/not-found.component';
import { HomeComponent } from './pages/home/home.component';
import { InscriptionSessionComponent } from './pages/inscription-session/inscription-session.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'catalogue', component: CatalogueComponent},
  {path: 'catalogue/:type', component: ThemeComponent},
  {path: 'catalogue/:type/:id', component: ThemeComponent},
  {path: 'catalogue/themes/:type', component: FormationComponent},
  {path: 'catalogue/themes/:type/:id', component: FormationComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'dashboard/formation/ajout', component: FormsFormationComponent},
  {path: 'dashboard/formation/modification', component: FormsFormationUpdateComponent},
  {path: 'dashboard/formation/modification/:id', component: FormationDetailsComponent},
  {path: 'dashboard/formation/suprression', component: FormsFormationUpdateComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'inscription/session', component:InscriptionSessionComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
