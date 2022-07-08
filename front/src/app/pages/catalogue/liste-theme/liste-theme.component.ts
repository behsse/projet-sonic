import { Component, Input, OnInit } from '@angular/core';
import Theme from 'src/app/models/theme.model';

@Component({
  selector: 'app-liste-theme',
  templateUrl: './liste-theme.component.html',
  styleUrls: ['./liste-theme.component.scss']
})
export class ListeThemeComponent implements OnInit {

 @Input() listeTheme:Theme[]=[];
  constructor() { }

  ngOnInit(): void {
  }

}
