
public class Fila {

    private Pessoa[] v;
    private int tamanho;
    private int chamadaPrioritarios;

    public Fila(int tamanho) {
        this.v = new Pessoa[tamanho];
        this.tamanho = 0;
    }

    public void enfileirar(Pessoa p) {
        if (p.isPrioritario()) {
            int posicao = buscarPosicaoNormal();
            if (posicao == -1) {
                v[tamanho] = p;
            } else {
                for (int i = tamanho; i > posicao; i--) {
                    v[i] = v[i - 1];
                }
                v[posicao] = p;
            }
        } else {
            v[tamanho] = p;
        }
        tamanho++;
    }

    public void enfileirarPrioridade(Pessoa p) {
        if (p.isPrioritario()) {
            int posicao = buscarPosicaoNormal();
            if (posicao == -1) {
                v[tamanho] = p;
            } else {
                for (int i = tamanho; i > posicao; i--) {
                    v[i] = v[i - 1];
                }
                v[posicao] = p;
            }
        } else {
            v[tamanho] = p;
        }
        tamanho++;
    }

    @Override

    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            s.append(v[i]);
            if (i < tamanho - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }

    public Pessoa verFrente() {
        if (tamanho == 0) {
            System.out.println("A pilha está vazia");
            return null;
        }

        return v[0];
    }

    public Pessoa chamarFila() {
        Pessoa pessoaChamada = null;
        int posicao = 0;
        if (tamanho == 0) {
            System.out.println("A fila está vazia");
            return null;
        }
        if (chamadaPrioritarios < 3) {
            posicao = buscarPosicaoPrioridade();
            if (posicao == -1) {
                posicao = 0;
                chamadaPrioritarios = 0;
            }
            pessoaChamada = v[posicao];
            for (int i = posicao; i < tamanho - 1; i++) {
                v[i] = v[i + 1];
            }
            tamanho--;
            if (pessoaChamada.isPrioritario()) {
                chamadaPrioritarios++;
            }
            return pessoaChamada;
        } else {
            posicao = buscarPosicaoNormal();
            pessoaChamada = v[posicao];
            for (int j = posicao; j < tamanho - 1; j++) {
                v[j] = v[j + 1];
            }
            if (chamadaPrioritarios == 3) {
                chamadaPrioritarios = 0;
            }
            tamanho--;
        }
        return pessoaChamada;
    }

    public int buscarPosicaoPrioridade() {
        for (int i = 0; i < tamanho; i++) {
            if (v[i].isPrioritario()) {
                return i;
            }
        }
        return -1;
    }

    public int buscarPosicaoNormal() {
        for (int i = 0; i < tamanho; i++) {
            if (!v[i].isPrioritario()) {
                return i;
            }
        }
        return -1;
    }

    public int retornarTamanho() {
        return tamanho;
    }

}
