import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import Formation from 'src/app/models/formation.model';
import Theme from 'src/app/models/theme.model';

import { FormationService } from 'src/app/service/formation.service';
import { ThemeService } from 'src/app/service/theme.service';


@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {

  formations: Formation[] = [];
  themes!: Theme;
  sousThemes: Theme [] = [];
  forma!: Formation;

  constructor(private formationService: FormationService, private themeService: ThemeService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {

    const type = this.route.snapshot.paramMap.get('type');
    const id = this.route.snapshot.paramMap.get('id');
    this.setSubscribe(type, id);

    this.formationService.getFormations().subscribe((formation) => {this.formations = formation});
    this.themeService.getThemes().subscribe((sousTheme) => {this.sousThemes = sousTheme});

  }

  private subscribeTheme(id : number) : void{
    this.themeService.getTheme((id)).subscribe((theme) => {
      this.themes = theme;
    });
  }

  private setSubscribe(type: string | null, id: string | null){
    if (id && type == 'themes'){
      this.subscribeTheme(+id);
    } else if (!id || !type) {
      this.router.navigate(['/not-found']);
    }
  }
}
