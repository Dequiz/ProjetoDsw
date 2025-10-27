public class ex3 {
    public static void main(String[] args) {
        int[] v = {10,20,30,40,12,50};
        int soma = 0,maiorN = 0,menorN = Integer.MAX_VALUE;
        double media = 0.0;

        for(int i = 0; i < v.length; i++){
         soma += v[i];
         if(v[i] > maiorN){
            maiorN = v[i];
         }
         if(v[i] < menorN){
            menorN = v[i];
         }

         media = soma / v.length ;

        }

        System.out.printf("A soma é %d %n A média é %f%nMaior Número = %d%nMenor Número = %d%n", soma,media,maiorN,menorN);

    }
}
