import { Component, OnInit } from '@angular/core';
import Domaine from 'src/app/models/domaine.model';

import Formation from 'src/app/models/formation.model';
import Theme from 'src/app/models/theme.model';

import { DomaineService } from 'src/app/service/domaine.service';
import { FormationService } from 'src/app/service/formation.service';
import { ThemeService } from 'src/app/service/theme.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {


  domaines : Domaine[] = [];
  themes : Theme[] = [];

  constructor(private domaineService : DomaineService, private themeService : ThemeService) { }

  ngOnInit(): void {


    this.domaineService.getDomaines().subscribe((domaine) => {this.domaines = domaine});
    this.themeService.getThemes().subscribe((theme) => {this.themes = theme});

  }

}
