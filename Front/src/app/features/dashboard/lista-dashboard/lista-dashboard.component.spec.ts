import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaDashboardComponent } from './lista-dashboard.component';

describe('ListaDashboardComponent', () => {
  let component: ListaDashboardComponent;
  let fixture: ComponentFixture<ListaDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
