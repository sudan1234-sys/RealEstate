import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellpropertyComponent } from './sellproperty.component';

describe('SellpropertyComponent', () => {
  let component: SellpropertyComponent;
  let fixture: ComponentFixture<SellpropertyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SellpropertyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellpropertyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
