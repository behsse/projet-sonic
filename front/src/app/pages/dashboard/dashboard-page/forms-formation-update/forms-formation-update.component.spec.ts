import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormsFormationUpdateComponent } from './forms-formation-update.component';

describe('FormsFormationUpdateComponent', () => {
  let component: FormsFormationUpdateComponent;
  let fixture: ComponentFixture<FormsFormationUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormsFormationUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormsFormationUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
