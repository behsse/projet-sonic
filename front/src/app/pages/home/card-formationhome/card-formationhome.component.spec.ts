import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardFormationhomeComponent } from './card-formationhome.component';

describe('CardFormationhomeComponent', () => {
  let component: CardFormationhomeComponent;
  let fixture: ComponentFixture<CardFormationhomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardFormationhomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardFormationhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
