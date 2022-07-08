import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormsFormationComponent } from './forms-formation.component';

describe('FormsFormationComponent', () => {
  let component: FormsFormationComponent;
  let fixture: ComponentFixture<FormsFormationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormsFormationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormsFormationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
