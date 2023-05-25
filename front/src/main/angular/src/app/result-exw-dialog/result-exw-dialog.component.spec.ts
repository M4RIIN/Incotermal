import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultEXWDialogComponent } from './result-exw-dialog.component';

describe('ResultDialogComponent', () => {
  let component: ResultEXWDialogComponent;
  let fixture: ComponentFixture<ResultEXWDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResultEXWDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultEXWDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
