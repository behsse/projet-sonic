import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import Formation from 'src/app/models/formation.model';
import { FormationService } from 'src/app/service/formation.service';

@Component({
  selector: 'app-forms-formation',
  templateUrl: './forms-formation.component.html',
  styleUrls: ['./forms-formation.component.scss']
})
export class FormsFormationComponent implements OnInit {
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

  // Ajout d'un boolean pour vérifier si le formulaire est soumis
  submitted: boolean = false;

  // Déclaration de la liste des formations
  formations: Formation[] = [];
  formationCree: Formation;

  // Déclaration du formbuilder dans le constructeur
  constructor( private formBuilder : FormBuilder, private formationService: FormationService) { }

  ngOnInit(): void {
      // A SUPPRIMER on init c'est lors du chargement du composant, formations est vide au chargement donc formations[0] n'existe pas, il faut pas l' envoyer au back
    //this.formationService.createFormation(this.formations[0]).subscribe((format) => {this.formations[0] = format});

  }

  // Déclaration d'une méthode pour ajouter les formations
  // Elle est privée et sera appelée par la méthode onSubmit
  private addFormation(){

    // Envoie de la formation au back
     this.formationService.createFormation(this.formationForm.value).subscribe(
      (format) => {
        this.formationCree = format;
         // Push du formulaire dans la liste
         this.formations.push( this.formationCree);
        console.log(format)
      },
      (error)=> {
        // en cas d'erreur
      console.error(error);
    });

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
      this.addFormation();
      console.log('valide');
      return true;
    }
  }

}
