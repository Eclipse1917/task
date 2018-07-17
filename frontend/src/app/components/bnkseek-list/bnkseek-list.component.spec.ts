import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BnkseekListComponent} from './bnkseek-list.component';

describe('BnkseekListComponent', () => {
  let component: BnkseekListComponent;
  let fixture: ComponentFixture<BnkseekListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BnkseekListComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BnkseekListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
