import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SousthemeComponent } from './soustheme.component';

describe('SousthemeComponent', () => {
  let component: SousthemeComponent;
  let fixture: ComponentFixture<SousthemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SousthemeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SousthemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
