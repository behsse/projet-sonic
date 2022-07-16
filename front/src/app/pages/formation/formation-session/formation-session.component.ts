import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import {  Subscription } from 'rxjs';
import Formation from 'src/app/models/formation.model';
import Session from 'src/app/models/session.model';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-formation-session',
  templateUrl: './formation-session.component.html',
  styleUrls: ['./formation-session.component.scss']
})
export class FormationSessionComponent implements OnInit, OnDestroy {

  @Input("formation") formation!: Formation;
  constructor(private sessionService: SessionService) { }
  abonnement: Subscription = new Subscription;
  sessionVilleMap = new Map<string, Session[]>();

  ngOnInit(): void {
  this.abonnement = this.sessionService.getSessionByFormationId(this.formation.id).subscribe(sessions => {
    sessions.forEach(session => this.addSessionToMap(session));
  })
  }

  ngOnDestroy(): void {
    this.abonnement.unsubscribe();
  }

  addSessionToMap(session: Session) {
    if(!session) {
      return;
    }
    let listeSessionsByLieu = this.sessionVilleMap.get(session.lieuSession);
    if(!listeSessionsByLieu) {
      listeSessionsByLieu = [];
    }
    listeSessionsByLieu.push(session);
    this.sessionVilleMap.set(session.lieuSession, listeSessionsByLieu);

  }

}
