import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BnkseeEditModalComponent} from './bnksee-edit-modal.component';

describe('BnkseeEditModalComponent', () => {
  let component: BnkseeEditModalComponent;
  let fixture: ComponentFixture<BnkseeEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BnkseeEditModalComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BnkseeEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
