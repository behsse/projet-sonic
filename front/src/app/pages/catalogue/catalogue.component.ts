import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import Domaine from 'src/app/models/domaine.model';
import Theme from 'src/app/models/theme.model';
import { DomaineService } from 'src/app/service/domaine.service';


@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.scss']
})
export class CatalogueComponent implements OnInit, OnDestroy {
  listeDomaine:Domaine []=[];
  domainesSelectionnes: Domaine [] = [];
  themesSelectionnes: Theme [] = [];
  abonnement: Subscription = new Subscription();
  constructor(private domaineService: DomaineService) { }

  ngOnInit(): void {
    this.abonnement = this.domaineService.getDomaines().subscribe((data: Domaine[]) => {
      this.listeDomaine = data;
    })
  }

  selectionnerDomaine(idDomaine: number) {
    if(idDomaine == -1) {
      this.domainesSelectionnes = this.listeDomaine;
    } else {
      this.domainesSelectionnes = [<Domaine>(this.listeDomaine.find(domaine => domaine.id === idDomaine))];
    }
    this.setThemesList();

  }
ngOnDestroy(): void {
  this.abonnement.unsubscribe();
}
setThemesList(): Theme[] {
  this.themesSelectionnes = this.domainesSelectionnes.flatMap(domaine => domaine.themesListe);
  return this.themesSelectionnes;
}



}
