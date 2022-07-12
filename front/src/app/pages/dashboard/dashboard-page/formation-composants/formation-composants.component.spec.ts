import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationComposantsComponent } from './formation-composants.component';

describe('FormationComposantsComponent', () => {
  let component: FormationComposantsComponent;
  let fixture: ComponentFixture<FormationComposantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormationComposantsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormationComposantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
