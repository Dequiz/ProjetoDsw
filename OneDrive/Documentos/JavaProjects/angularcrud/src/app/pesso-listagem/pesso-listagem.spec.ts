import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoListagem } from './pesso-listagem';

describe('PessoListagem', () => {
  let component: PessoListagem;
  let fixture: ComponentFixture<PessoListagem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PessoListagem]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PessoListagem);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
