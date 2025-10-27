package adoed;

public class EstoqueLana {
    private String produto;
    private int quantidade;
    private double preco;

    public EstoqueLana(String produto, int quantidade, double preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s\nQuantidade: %d\nPreco: %.2f%n", produto, quantidade, preco);
    }
}
