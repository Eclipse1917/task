import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BnkseeRemoveModalComponent} from './bnksee-remove-modal.component';

describe('BnkseeRemoveModalComponent', () => {
  let component: BnkseeRemoveModalComponent;
  let fixture: ComponentFixture<BnkseeRemoveModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BnkseeRemoveModalComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BnkseeRemoveModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
