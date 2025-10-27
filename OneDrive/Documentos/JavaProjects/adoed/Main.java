package adoed;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(10);
        int opt = 0;
        JOptionPane.showMessageDialog(null,"=====Seja bem vindo ao controle de estoque da loja=====");
        do{
         opt = Integer.parseInt(JOptionPane.showInputDialog("O que deseja fazer\n0)Sair\n1)Adicionar Produto\n2)Remover Produto\n3)Buscar Produto\n4)Buscar por nome\n5)Listar Produtos\n6)Alterar Produto"));
            switch (opt){
                case 1:
                    String p = JOptionPane.showInputDialog("Digite o nome do produto");
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto"));
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto"));
                    EstoqueLana p1 = new EstoqueLana(p,qtd,price);
                    vetor.adiciona(p1);
                    break;

                case 2:
                    if (vetor.tamanho() == 0){
                      JOptionPane.showMessageDialog(null,"Necessário adicionar um produto");
                    }else{
                        int r = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do produto"));
                        vetor.remove(r);
                        JOptionPane.showMessageDialog(null,"Produto removido com sucesso");
                    }
                    break;
                case 3:
                    if (vetor.tamanho() == 0){
                        JOptionPane.showMessageDialog(null,"Necessário adicionar um produto");
                    }else{
                        int busca =  Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do produto"));
                        JOptionPane.showMessageDialog(null,"Na posição " + busca + "se encontra o produto: " + vetor.busca(busca));
                    }

                    break;
                case 4:
                    if (vetor.tamanho() == 0){
                        JOptionPane.showMessageDialog(null,"Necessário adicionar um produto");
                    }else {
                        String bpn =  JOptionPane.showInputDialog("Digite o nome do produto");
                        JOptionPane.showMessageDialog(null,"Produto:" + bpn + " foi encontrado na posição " + vetor.busca1(bpn));
                    }
                    break;
                case 5:
                    if (vetor.tamanho() == 0){
                        JOptionPane.showMessageDialog(null,"Necessário adicionar um produto");

                    }else{
                    JOptionPane.showMessageDialog(null, vetor.toString());
                    }
                    break;
                case 6:
                    if (vetor.tamanho() == 0){
                        JOptionPane.showMessageDialog(null,"Necessário adicionar um produto");
                    }else{
                        String nomeBusca = JOptionPane.showInputDialog("Digite o nome do produto que deseja alterar:");
                        int pos = vetor.busca1(nomeBusca);

                        if (pos != -1) {
                            EstoqueLana produto = (EstoqueLana) vetor.busca(pos);

                            String novoNome = JOptionPane.showInputDialog("Novo nome do produto:");
                            int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Nova quantidade:"));
                            double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço:"));

                            produto.setProduto(novoNome);
                            produto.setQuantidade(novaQuantidade);
                            produto.setPreco(novoPreco);

                            JOptionPane.showMessageDialog(null, "Produto atualizado:\n" + produto);
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                        }
                    }
                    break;
            }
        }while(opt != 0);
    }
}
