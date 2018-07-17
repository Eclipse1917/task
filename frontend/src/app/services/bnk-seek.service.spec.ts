import {TestBed, inject} from '@angular/core/testing';

import {BnkSeekService} from './bnk-seek.service';

describe('BnkSeekService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BnkSeekService]
    });
  });

  it('should be created', inject([BnkSeekService], (service: BnkSeekService) => {
    expect(service).toBeTruthy();
  }));
});
