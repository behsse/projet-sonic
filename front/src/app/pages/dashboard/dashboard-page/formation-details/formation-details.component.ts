import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Formation from 'src/app/models/formation.model';
import { FormationService } from 'src/app/service/formation.service';

@Component({
  selector: 'app-formation-details',
  templateUrl: './formation-details.component.html',
  styleUrls: ['./formation-details.component.scss']
})
export class FormationDetailsComponent implements OnInit {

  id: number;

  formationForm: FormGroup = this.formBuilder.group ({
    reference: ['', Validators.required],
    intitule: ['', Validators.required],
    publicConcerne: ['', Validators.required],
    description: ['', Validators.required],
    objectif: ['', Validators.required],
    prerequis: ['', Validators.required],
    duree: ['', Validators.required],
    estIntra: [0, Validators.required],
    distanciel: [0, Validators.required],
    image: [''],
    tarif: ['', Validators.required],
    theme: {},
    session: {}
  })

  displayErrorMessage = false;
  displayLoading = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private formationService: FormationService,
    private formBuilder : FormBuilder) {
    this.id = this.route.snapshot.params['id'];
  }

  // get estIntra() {
  //   return this.formationForm.value.estIntra;
  // }

  // get distanciel() {
  //   return this.formationForm.value.distanciel;
  // }

  ngOnInit(): void {
    this.initFormation();
  }

  initFormation() {
    this.formationService.getFormation(this.id).subscribe({
      next: (data) => {
        this.formationForm.patchValue(data);
      }
    })
  }

  updateFormation(){
    this.displayLoading = true;
    let formation : Formation = new Formation(
      this.id,
      this.formationForm.value.reference,
      this.formationForm.value.intitule,
      this.formationForm.value.publicConcerne,
      this.formationForm.value.description,
      this.formationForm.value.objectif,
      this.formationForm.value.prerequis,
      this.formationForm.value.duree,
      this.formationForm.value.estIntra,
      this.formationForm.value.distanciel,
      this.formationForm.value.image,
      this.formationForm.value.tarif,
      this.formationForm.value.theme,
      this.formationForm.value.session,
    );

    this.formationService.updateFormation(formation).subscribe({
      next: () => {
        this.router.navigateByUrl('/dashboard/formation/modification');
      },
      error: () => {
        this.displayErrorMessage = true;
        this.displayLoading = false;
      }
    })
  }

  cancel() {
    this.router.navigateByUrl('/dashboard/formation/modification');
  }

}
