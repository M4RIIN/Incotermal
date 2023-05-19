import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonotComparaisonComponent } from './donot-comparaison.component';

describe('DonotComparaisonComponent', () => {
  let component: DonotComparaisonComponent;
  let fixture: ComponentFixture<DonotComparaisonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DonotComparaisonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DonotComparaisonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
