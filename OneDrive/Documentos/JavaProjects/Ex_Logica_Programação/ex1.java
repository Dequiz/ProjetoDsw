
import java.util.Arrays;

public class ex1 {

    public static void main(String[] args) {
       matriz();
    }

    public static void isPar(int n){
        if(n % 2 == 0){
            System.out.printf("%d é par%n",n);
        }else{
            System.out.printf("%d é impar%n",n);
        }
    }

    public static void maiorNumero(int n, int m){
        if(n > m){
            System.out.printf("%d é maior que %d%n",n,m);
        }else if(n == m){
             System.out.printf("%d é igual a %d%n",n,m);
        }else{
             System.out.printf("%d é menor que %d%n",n,m);
        }
    }

    public static void tabuada(int n){
        for(int i = 1; i <= 10; i++ ){
            System.out.printf("%d x %d = %d%n",n,i,n*i);
        }
    }

    public static void mediaSimples(double n1, double n2, double n3){
        double media = (n1 + n2 + n3) / 3;
        if(media >= 7){
            System.out.printf("Aluno aprovado com média %.2f",media);
        }else{
             System.out.printf("Aluno reprovado com média %.2f",media);
        }
    }

    public static void fatorial(int n){
       int f = 1;
       for(int i = n; i > 1; i--){
        f *= i;
    }
    System.out.println(f); 
    }

    public static void inverterNumero(String n){
        String[] numeros = n.split("");
        for(int i = numeros.length - 1 ; i >= 0; i--){
            System.out.printf("%s",numeros[i]);
        }
    }

    public static void fibonacci(int n){
        int[] fibonacci = new int[n] ;
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i = 2; i < n; i++){
           fibonacci[i] = fibonacci[i-1] + fibonacci[i-2]; 
        }
       System.out.println(Arrays.toString(fibonacci));
    }

    public static void somatoria(int n){
        int r = 0;
        for(int i = 1; i <= n;i++){ 
            r += i;
        }
        System.out.println(r);
    }

    public static void palindromo(String s){
        String sInvertida = new StringBuilder(s).reverse().toString();

        if(s.equals(sInvertida)){
            System.out.println("É um palindromo");
        }else{
            System.out.println("Não é um palindromo");
        }
    }

    public static void matriz(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3;j++){
                if(i == j){
                    System.out.printf(" 1 ");
                }else{
                    System.out.printf(" 0 ");
                }
            }
            System.out.println();
        }
    }
}