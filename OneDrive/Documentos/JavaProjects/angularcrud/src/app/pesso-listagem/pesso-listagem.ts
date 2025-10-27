import { Pessoa } from '../core/types/types';
import { Component, OnInit } from '@angular/core';
import { PessoaService } from '../core/services/pessoa';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
	selector: 'app-pesso-listagem',
	standalone: true,
	imports: [CommonModule, RouterModule],
	templateUrl: './pesso-listagem.html',
	styleUrls: ['./pesso-listagem.scss']
})
export class PessoListagem implements OnInit {
	listaPessoas: Pessoa[] = [];

	constructor(
		private service: PessoaService,
		private router: Router
	) {}

	ngOnInit(): void {
		this.service.listar().subscribe((pessoas: Pessoa[]) => {
			this.listaPessoas = pessoas;
		});
	}

	excluir(id?: number) {
		if (!id) return;
		this.service.excluir(id).subscribe(() => {
			this.listaPessoas = this.listaPessoas.filter(p => p.id !== id);
		});
	}
}
