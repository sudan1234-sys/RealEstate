import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HousepriceComponent } from './houseprice.component';

describe('HousepriceComponent', () => {
  let component: HousepriceComponent;
  let fixture: ComponentFixture<HousepriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HousepriceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HousepriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
