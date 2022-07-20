import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Formation from 'src/app/models/formation.model';
import Theme from 'src/app/models/theme.model';
import { FormationService } from 'src/app/service/formation.service';
import { ThemeService } from 'src/app/service/theme.service';

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
    distanciel: ['', Validators.required],
    themeId: [0, Validators.required],
    theme: {},
    sousThemeId:[0, Validators.required],
    sousTheme: {},
    image: [''],
    tarif: ['', Validators.required],

  })

  newVal: any;

  // Ajout d'un boolean pour vérifier si le formulaire est soumis
  submitted: boolean = false;

  // Déclaration de la liste des formations
  formations: Formation[] = [];

  themes: Theme[] = [];

  // Déclaration du formbuilder dans le constructeur
  constructor(private router: Router, private route: ActivatedRoute,private formBuilder : FormBuilder, private formationService: FormationService, private themeService: ThemeService) { }

  ngOnInit(): void {

    this.themeService.getThemes().subscribe((theme) => {this.themes = theme});

  }

  get themeId() {
    return this.formationForm.value.themeId
  }

  // Déclaration d'une méthode pour ajouter les formations
  // Elle est privée et sera appelée par la méthode onSubmit
  private addFormation(){

    // Envoie de la formation au back
     this.formationService.createFormation(this.formationForm.value).subscribe({
      next: (format) => {
        // Push du formulaire dans la liste uniquement quand la formation a bien été ajouté à la bdd, réponse du back ok
        this.formations.push(format);
       console.log(format)
     },
     error: (error)=> {
       // en cas d'erreur
     console.error(error);
     }
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

      this.formationForm.value.theme = this.themes.filter(t => t.id == this.formationForm.value.themeId)[0];
      this.formationForm.value.theme = this.themes.filter(t => t.id == this.formationForm.value.sousThemeId)[0];
      this.addFormation();
      console.log('valide');
      this.goToDashboard();
      return true;
    }
  }

  getListTheme(): Theme[] {
    let themes : Theme[] = [];
    for(let theme of this.themes){
      if(theme.estSousTheme == false){
        themes.push(theme);
      }
    }
    return themes;
  }

  getListSousTheme(): Theme[] {
    let theme : Theme = this.themes.filter(t => t.id == this.formationForm.value.themeId)[0];
    return theme.sousThemeListe
  }

  onChange(event: any) :void{
    this.newVal = event.target.value;
    console.log(this.newVal);

  }

  goToDashboard(){
    this.router.navigateByUrl('/dashboard');
  }

}
