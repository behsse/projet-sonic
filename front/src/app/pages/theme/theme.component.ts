import { Component, OnInit } from '@angular/core';
import Formation from 'src/app/models/formation.model';
import { FormationService } from 'src/app/service/formation.service';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {

  formations: Formation[] = [];

  constructor(private formationService: FormationService) { }

  ngOnInit(): void {

    this.formationService.getFormations().subscribe((formation) => {this.formations = formation});
  }

}
