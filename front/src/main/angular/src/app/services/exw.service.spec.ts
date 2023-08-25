import { TestBed } from '@angular/core/testing';

import { ExwService } from './exw.service';

describe('ExwService', () => {
  let service: ExwService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExwService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
