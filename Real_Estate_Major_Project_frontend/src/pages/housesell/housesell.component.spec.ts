import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HousesellComponent } from './housesell.component';

describe('HousesellComponent', () => {
  let component: HousesellComponent;
  let fixture: ComponentFixture<HousesellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HousesellComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HousesellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
