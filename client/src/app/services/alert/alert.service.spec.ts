import { TestBed, inject } from '@angular/core/testing';
import { AlertService } from './alert.service';
import { checkAndUpdateBinding } from '@angular/core/src/view/util';

describe('AlertService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AlertService]
    });
  });

  it('should be created', inject([AlertService], (service: AlertService) => {
    expect(service).toBeTruthy();
  }));
});
