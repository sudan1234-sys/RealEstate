import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BidingsystemComponent } from './bidingsystem.component';

describe('BidingsystemComponent', () => {
  let component: BidingsystemComponent;
  let fixture: ComponentFixture<BidingsystemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BidingsystemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BidingsystemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
