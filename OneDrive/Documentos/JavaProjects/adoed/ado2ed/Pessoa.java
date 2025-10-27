public class Pessoa {
    private  String nome;
    private  boolean prioritario;

    public Pessoa(String nome, boolean prioritario){
        this.nome = nome;
        this.prioritario = prioritario;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public boolean getPrioritario(){
        return prioritario;
    }
    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public boolean isPrioritario(){
        return getPrioritario();
    }

    @Override
    public String toString() {
        return nome + (prioritario ? " (Prioritário)" : " (Normal)");
    }
}
