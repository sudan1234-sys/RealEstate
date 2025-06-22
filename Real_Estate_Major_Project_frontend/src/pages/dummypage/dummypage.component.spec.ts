import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DummypageComponent } from './dummypage.component';

describe('DummypageComponent', () => {
  let component: DummypageComponent;
  let fixture: ComponentFixture<DummypageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DummypageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DummypageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
