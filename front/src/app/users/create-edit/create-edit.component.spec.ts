import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEditUsersComponent } from './create-edit.component';

describe('CreateEditComponent', () => {
  let component: CreateEditUsersComponent;
  let fixture: ComponentFixture<CreateEditUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateEditUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateEditUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
