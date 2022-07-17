import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Domaine from 'src/app/models/domaine.model';
import Theme from 'src/app/models/theme.model';

@Component({
  selector: 'app-liste-theme',
  templateUrl: './liste-theme.component.html',
  styleUrls: ['./liste-theme.component.scss']
})
export class ListeThemeComponent implements OnInit {

 @Input()
  domaine!: Domaine;
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  selectTheme(idTheme: number) {
    this.router.navigate(['/catalogue', 'themes', idTheme]);
  }

}
