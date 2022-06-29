import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

// Import des models
import Formation from 'src/app/models/formation.model';

// Import des services
import { FormationService } from 'src/app/service/formation.service';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.scss']
})
export class FormationComponent implements OnInit {

  formation!: Formation;

  constructor(private router: Router, private route: ActivatedRoute, private formationService: FormationService) { }

  ngOnInit(): void {
    const type = this.route.snapshot.paramMap.get('type');
    const id = this.route.snapshot.paramMap.get('id');
    // this.setSubscribe(type, id);
  }

  // private subscribeFormation(id: number): void{
  //   this.formationService.getFormation(id).subscribe((formation : Formation) => {
  //     this.formation = formation;
  //   })
  // }

  // private setSubscribe(type: string | null, id: string | null){
  //   if (id && type == 'formations'){
  //     this.subscribeFormation(+id);
  //   }else if (!id || !type){
  //     this.router.navigate(['/not-found']);
  //   }
  // }

}
