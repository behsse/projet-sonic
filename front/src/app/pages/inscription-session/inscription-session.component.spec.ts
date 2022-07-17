import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionSessionComponent } from './inscription-session.component';

describe('InscriptionSessionComponent', () => {
  let component: InscriptionSessionComponent;
  let fixture: ComponentFixture<InscriptionSessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionSessionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InscriptionSessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
