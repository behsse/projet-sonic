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
  domaineSelectionne: Domaine;
  abonnement: Subscription = new Subscription();
  constructor(private domaineService: DomaineService) { }

  ngOnInit(): void {
    this.abonnement = this.domaineService.getDomaines().subscribe((data: Domaine[]) => {
      this.listeDomaine = data;
    })
  }

  selectionnerDomaine(idDomaine: number) {
    this.domaineSelectionne = <Domaine>(this.listeDomaine.find(domaine => domaine.id === idDomaine));

  }
ngOnDestroy(): void {
  this.abonnement.unsubscribe();
}
getThemesList(): Theme[] {
  return this.domaineSelectionne?.themesListe || [];
}


}
