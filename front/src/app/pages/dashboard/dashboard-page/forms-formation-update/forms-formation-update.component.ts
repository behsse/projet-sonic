import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

import Formation from 'src/app/models/formation.model';
import { FormationService } from 'src/app/service/formation.service';

@Component({
  selector: 'app-forms-formation-update',
  templateUrl: './forms-formation-update.component.html',
  styleUrls: ['./forms-formation-update.component.scss']
})
export class FormsFormationUpdateComponent implements OnInit {

  formationForm: FormGroup = this.formBuilder.group ({
    reference: ['', Validators.required],
    intitule: ['', Validators.required],
    publicConcerne: ['', Validators.required],
    description: ['', Validators.required],
    objectif: ['', Validators.required],
    prerequis: ['', Validators.required],
    duree: ['', Validators.required],
    estIntra: ['', Validators.required],
    estDistanciel: ['', Validators.required]
  })

  formations: Formation[] = [];
  Allformations: Formation[] = [];

  submitted: boolean = false;

  constructor( private formBuilder : FormBuilder, private formationService : FormationService) { }

  ngOnInit(): void {

    this.formationService.getFormations().subscribe((formation) => {this.Allformations = formation});
    this.formationService.updateFormation(this.formations[0]).subscribe((formation) => {this.formations[0] = formation});
  }


  private updateFormation(){
    // Push du formulaire dans la liste
    this.formations.push(this.formationForm.value);
    //Reset du formulaire
    this.formationForm.reset();
    // On repasse submitted à false
    this.submitted = false;
  }
    // Méthode onSubmit pour gérer la soumission
    onSubmit(): boolean {
      this.submitted = true;
      // Appel du validateur "invalid" pour vérifier
      if (this.formationForm.invalid){
        console.log('pas valide');
        return false;
      } else {
        // Si le formulaire est valide, on appelle la méthode addFormation
        this.updateFormation();
        console.log('valide');
        return true;
      }
    }


}

