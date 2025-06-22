import { TestBed } from '@angular/core/testing';

import { AddtofavourateService } from './addtofavourate.service';

describe('AddtofavourateService', () => {
  let service: AddtofavourateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddtofavourateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
