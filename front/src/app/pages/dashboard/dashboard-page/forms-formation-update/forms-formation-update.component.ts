import { Component, OnInit } from '@angular/core';

import Formation from 'src/app/models/formation.model';
import { FormationService } from 'src/app/service/formation.service';

@Component({
  selector: 'app-forms-formation-update',
  templateUrl: './forms-formation-update.component.html',
  styleUrls: ['./forms-formation-update.component.scss']
})
export class FormsFormationUpdateComponent implements OnInit {

  formations: Formation[] = [];

  errorMessage : any = null;


  constructor(private formationService : FormationService) { }

  ngOnInit(): void {
    this.initFormation();
  }

  initFormation(){
    this.formationService.getFormations().subscribe({
      next: (data) => {
        this.formations = data;
      },
      error: (err) => {
        this.errorMessage = err;
      }
    })
  }

  deleteFormation(id: number){
    this.formationService.deleteFormation(id).subscribe({
      next: () => {
        this.initFormation()
      }
    })
  }


}

