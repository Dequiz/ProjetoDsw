
public class ClienteBanco {
    private String nome;
    private String cpf;
    private String endereco;

    
     public ClienteBanco(){

    }
    
    public ClienteBanco(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

   
    public String getCpf() {
        return cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getNome() {
        return nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    @Override
    public String toString(){
        return "O Sr(a). " + nome + " portador do CPF n. " + cpf + " residente e domiciliado a " + endereco + " vem por meio desta solicitar o encerramento da sua conta corrente";
    }

}
