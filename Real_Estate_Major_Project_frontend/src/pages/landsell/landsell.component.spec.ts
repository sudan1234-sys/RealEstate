import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandsellComponent } from './landsell.component';

describe('LandsellComponent', () => {
  let component: LandsellComponent;
  let fixture: ComponentFixture<LandsellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LandsellComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LandsellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
