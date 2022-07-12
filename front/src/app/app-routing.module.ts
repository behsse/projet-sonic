import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogueComponent } from './pages/catalogue/catalogue.component';
import { FormationComposantsComponent } from './pages/dashboard/dashboard-page/formation-composants/formation-composants.component';
import { FormationDetailsComponent } from './pages/dashboard/dashboard-page/formation-details/formation-details.component';
import { FormsFormationUpdateComponent } from './pages/dashboard/dashboard-page/forms-formation-update/forms-formation-update.component';
import { FormsFormationComponent } from './pages/dashboard/dashboard-page/forms-formation/forms-formation.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { FormationComponent } from './pages/formation/formation.component';
import { ThemeComponent } from './pages/theme/theme.component';
import { NotFoundComponent } from './_commons/not-found/not-found.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'catalogue', component: CatalogueComponent},
  {path: 'catalogue/:type', component: ThemeComponent},
  {path: 'catalogue/:type/:id', component: ThemeComponent},
  {path: 'catalogue/themes/:type', component: FormationComponent},
  {path: 'catalogue/themes/:type/:id', component: FormationComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'dashboard/formation/ajout', component: FormsFormationComponent},
  {path: 'dashboard/formation/modification', component: FormsFormationUpdateComponent},
  {path: 'dashboard/formation/modification/:id', component: FormationDetailsComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
