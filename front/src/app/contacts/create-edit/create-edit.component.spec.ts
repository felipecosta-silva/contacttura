import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEditContactsComponent } from './create-edit.component';

describe('CreateEditComponent', () => {
  let component: CreateEditContactsComponent;
  let fixture: ComponentFixture<CreateEditContactsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateEditContactsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateEditContactsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
