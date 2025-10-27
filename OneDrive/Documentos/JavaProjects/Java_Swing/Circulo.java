public class Circulo{ 
 	double raio; 

    public double getRaio() {
        return raio;
    }
    public void setRaio(double raio) {
        if(raio >= 0){
            this.raio = raio;
        }
        else{
            System.out.println("Valor inválido");
        }
    }
} 

