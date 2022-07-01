import { Component, OnInit } from '@angular/core';
import Domaine from 'src/app/models/domaine.model';

import Formation from 'src/app/models/formation.model';
import { DomaineService } from 'src/app/service/domaine.service';
import { FormationService } from 'src/app/service/formation.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  formations: Formation[] = [];
  domaines : Domaine[] = [];

  constructor(private formationService: FormationService, private domaineService : DomaineService) { }

  ngOnInit(): void {

    this.formationService.getFormations().subscribe((formation) => {this.formations = formation})
    this.domaineService.getDomaines().subscribe((domaine) => {this.domaines = domaine});

  }

}
