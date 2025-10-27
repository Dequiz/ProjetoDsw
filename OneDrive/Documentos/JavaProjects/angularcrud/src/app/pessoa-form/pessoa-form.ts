import { FormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Pessoa } from '../core/types/types';
import { PessoaService } from '../core/services/pessoa';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
	selector: 'app-pessoa-form',
	imports: [FormsModule, RouterModule],
	standalone: true,
	templateUrl: './pessoa-form.html',
	styleUrls: ['./pessoa-form.scss'],

})
export class PessoaFormComponent {
titulo = 'Cadastro de Pessoas';
pessoaId?: number;

pessoa: Pessoa = {} as Pessoa;
constructor(
private service: PessoaService,
private router: Router,
private route: ActivatedRoute
) {

this.pessoaId = Number(this.route.snapshot.params['id']);
if (this.pessoaId) {
			this.service.buscarPorId(this.pessoaId).subscribe((pessoa: Pessoa | undefined) => {
				if (pessoa) {
this.pessoa.id = pessoa.id;
this.pessoa.nome = pessoa.nome;
this.pessoa.sobrenome = pessoa.sobrenome;
this.pessoa.dtNascimento = pessoa.dtNascimento;
}
});
}
}
submeter() {
if (this.pessoaId) {
this.service.editar(this.pessoa).subscribe(() => {
this.router.navigate(['/pessoas']);
});
} else {
this.service.incluir(this.pessoa).subscribe(() => {
this.router.navigate(['/pessoas']);
});
}
}
}
