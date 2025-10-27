package adoed;
import java.util.Arrays;
public class Vetor{
    private Object[] elementos;
    private int tamanho;

    public Vetor(int capacidade){
        this.elementos = new  Object[capacidade];
        this.tamanho = 0;
    }

    public void adiciona( Object elemento) throws Exception{
        this.aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;

    }

    public int tamanho(){
        return this.tamanho;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if(this.tamanho > 0){
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");

        return s.toString();
    }

    public  Object busca(int posicao) throws Exception{
        if(posicao >= 0 && posicao < tamanho){
            return this.elementos[posicao];
        }else{
            throw  new Exception("Posicao Invalida");
        }
    }

    public int busca1( String nomeProduto){
        for(int i = 0; i < this.tamanho; i++){
            EstoqueLana produto =  (EstoqueLana)this.elementos[i];
            if(produto.getProduto().equalsIgnoreCase(nomeProduto)){
                return i;
            }
        }
        return -1;
    }

    public boolean adicionaInicio(int posicao,  Object elemento) throws Exception{
        this.aumentaCapacidade();
        if(posicao >= 0 && posicao < tamanho){
            for(int i = this.tamanho - 1; i >= posicao; i--){
                this.elementos[i + 1] =  this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        }
        return true;
    }

    public void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            Object[] elementosNovos = new  Object[this.elementos.length * 2];
            for(int i = 0; i < this.elementos.length; i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public void remove(int posicao) throws Exception{
        if(posicao >= 0 && posicao < tamanho){
            for(int i = posicao; i < tamanho - 1; i++){
                this.elementos[i] = elementos[i+1];
            }
            this.elementos[tamanho] = null;
            this.tamanho--;
        }else{
            throw  new Exception("Posicao Invalida");
        }
    }
}