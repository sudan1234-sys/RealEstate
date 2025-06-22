import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivebidskeletonComponent } from './activebidskeleton.component';

describe('ActivebidskeletonComponent', () => {
  let component: ActivebidskeletonComponent;
  let fixture: ComponentFixture<ActivebidskeletonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActivebidskeletonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActivebidskeletonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
