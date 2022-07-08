import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-forms-formation',
  templateUrl: './forms-formation.component.html',
  styleUrls: ['./forms-formation.component.scss']
})
export class FormsFormationComponent implements OnInit {

  formationUpadate: FormGroup = this.formBuilder.group ({
    intitule: ['', Validators.required],
    publicConcerne: ['', Validators.required],
    description: ['', Validators.required],
    objectif: ['', Validators.required],
    prerequis: ['', Validators.required],
    duree: ['', Validators.required],
    estIntra: ['', Validators.required],
    estDistanciel: ['', Validators.required],
    reference: ['', Validators.required]
  })

  submitted: boolean = false;

  formation: any[] = [];

  constructor( private formBuilder : FormBuilder) { }

  ngOnInit(): void {
  }

}
