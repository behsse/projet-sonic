import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-forms-formation',
  templateUrl: './forms-formation.component.html',
  styleUrls: ['./forms-formation.component.scss']
})
export class FormsFormationComponent implements OnInit {

  formation: FormGroup = this.formBuilder.group ({

  })

  constructor( private formBuilder : FormBuilder) { }

  ngOnInit(): void {
  }

}
