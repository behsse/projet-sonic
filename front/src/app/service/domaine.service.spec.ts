import { TestBed } from '@angular/core/testing';

import { DomaineService } from './domaine.service';

describe('ModelService', () => {
  let service: DomaineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DomaineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
