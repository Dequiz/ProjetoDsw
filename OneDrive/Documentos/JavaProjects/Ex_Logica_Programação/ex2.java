import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = new int[3];
        int maiorN = 0;
        
        System.out.println("Coloque o primeiro n");
        v[0] = sc.nextInt();
        System.out.println("Coloque o segundo n");
       v[1] = sc.nextInt();
        System.out.println("Coloque o terceiro n");
       v[2] = sc.nextInt();


       for(int i = 0; i < v.length; i++){ 
        if(v[i] > maiorN){
            maiorN = v[i];
        }
       }

       System.out.println(maiorN);
    }
}
