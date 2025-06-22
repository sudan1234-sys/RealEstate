import { TestBed } from '@angular/core/testing';

import { TophouseandlandService } from './tophouseandland.service';

describe('TophouseandlandService', () => {
  let service: TophouseandlandService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TophouseandlandService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
