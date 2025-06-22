import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedpropertiesComponent } from './savedproperties.component';

describe('SavedpropertiesComponent', () => {
  let component: SavedpropertiesComponent;
  let fixture: ComponentFixture<SavedpropertiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SavedpropertiesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavedpropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
