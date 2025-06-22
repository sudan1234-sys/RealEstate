import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BidskeletonComponent } from './bidskeleton.component';

describe('BidskeletonComponent', () => {
  let component: BidskeletonComponent;
  let fixture: ComponentFixture<BidskeletonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BidskeletonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BidskeletonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
