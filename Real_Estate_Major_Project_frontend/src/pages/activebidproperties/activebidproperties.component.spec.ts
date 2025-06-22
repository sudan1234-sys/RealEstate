import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivebidpropertiesComponent } from './activebidproperties.component';

describe('ActivebidpropertiesComponent', () => {
  let component: ActivebidpropertiesComponent;
  let fixture: ComponentFixture<ActivebidpropertiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActivebidpropertiesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActivebidpropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
