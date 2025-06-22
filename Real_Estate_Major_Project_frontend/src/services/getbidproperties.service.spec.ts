import { TestBed } from '@angular/core/testing';

import { GetbidpropertiesService } from './getbidproperties.service';

describe('GetbidpropertiesService', () => {
  let service: GetbidpropertiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetbidpropertiesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
