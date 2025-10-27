import { Routes } from '@angular/router';
import { PessoListagem } from './pesso-listagem/pesso-listagem';
import { PessoaFormComponent } from './pessoa-form/pessoa-form';

export const routes: Routes = [
  {
    path: '',
    component: PessoListagem,
    title: 'Home',
  },
{
path: 'pessoas',
component: PessoListagem,
title: 'Pessoas',
},
{
path: 'pessoas/incluir',
component: PessoaFormComponent,
title: 'Pessoas - Incluir',
},
{
path: 'pessoas/alterar/:id',
component: PessoaFormComponent,
title: 'Pessoas - Alterar',
}]
