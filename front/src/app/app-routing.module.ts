import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormationComponent } from './pages/formation/formation.component';
import { NotFoundComponent } from './_commons/not-found/not-found.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'catalogue', component: FormationComponent},
  {path: 'catalogue/:type', component: FormationComponent},
  {path: 'catalogue/:type/:id', component: FormationComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
