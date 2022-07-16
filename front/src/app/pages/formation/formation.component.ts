import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

// Import des models
import Formation from 'src/app/models/formation.model';
import Session from 'src/app/models/session.model';
import Domaine from 'src/app/models/domaine.model';

// Import des services
import { FormationService } from 'src/app/service/formation.service';
import { SessionService } from 'src/app/service/session.service';
import { DomaineService } from 'src/app/service/domaine.service';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.scss']
})
export class FormationComponent implements OnInit {

  formation!: Formation;
  formations: Formation[] = [];
  sessions : Session[] = [];

  constructor(private formationService: FormationService, private sessionService: SessionService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const type = this.route.snapshot.paramMap.get('type');
    const id = this.route.snapshot.paramMap.get('id');
    this.setSubscribe(type, id);

    this.formationService.getFormations().subscribe((formation) => {this.formations = formation});
    this.sessionService.getSessions().subscribe((session) => {this.sessions = session});

  }

  private subscribeFormation(id : number) : void{
    this.formationService.getFormation((id)).subscribe((formation) => {
      this.formation = formation;
      console.log(this.formation);
    });
  }

  private setSubscribe(type: string | null, id: string | null){
    if (id && type == 'formations'){
      this.subscribeFormation(+id);
    } else if (!id || !type) {
      this.router.navigate(['/not-found']);
    }
  }

  goToSession(){
    document.getElementById('session')?.scrollIntoView();
  }
}
