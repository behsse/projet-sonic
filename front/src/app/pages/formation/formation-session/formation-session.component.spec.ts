import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationSessionComponent } from './formation-session.component';

describe('FormationSessionComponent', () => {
  let component: FormationSessionComponent;
  let fixture: ComponentFixture<FormationSessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormationSessionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormationSessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
