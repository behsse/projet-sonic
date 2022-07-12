import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import Formation from 'src/app/models/formation.model';

@Component({
  selector: 'app-formation-composants',
  templateUrl: './formation-composants.component.html',
  styleUrls: ['./formation-composants.component.scss']
})
export class FormationComposantsComponent implements OnInit {

  @Input() formation !: Formation;

  @Output() deleteFormationEvent = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  deleteFormation(){
    this.deleteFormationEvent.emit(this.formation.id);
  }

}
