import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaForm } from './pessoa-form';

describe('PessoaForm', () => {
  let component: PessoaForm;
  let fixture: ComponentFixture<PessoaForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PessoaForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PessoaForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
