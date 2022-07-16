import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import Formation from 'src/app/models/formation.model';
import Theme from 'src/app/models/theme.model';
import { FormationService } from 'src/app/service/formation.service';
import { ThemeService } from 'src/app/service/theme.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  formations: Formation[] = [];
  themes: Theme[] = [];


  constructor(private formationService: FormationService, private themeService: ThemeService, private router: Router,
    private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.formationService.getFormations().subscribe((formation) => {this.formations = formation});
    this.themeService.getThemes().subscribe((theme) => {this.themes = theme});
  }
}
