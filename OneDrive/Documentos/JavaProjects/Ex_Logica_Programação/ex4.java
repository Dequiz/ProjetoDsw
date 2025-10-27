
import java.util.Arrays;

public class ex4 {
    public static void main(String[] args) {
        String palavra = "programacao";
        int a = 0, e = 0,i = 0,o = 0,u = 0;
        
        String[] v = palavra.split("");

        System.out.println(Arrays.toString(v));

        for(int j = 0; j < v.length;j++){
            if(v[j].equalsIgnoreCase("a")){
              a++;
            }
            if(v[j].equalsIgnoreCase("e")){
              e++;
            }
            if(v[j].equalsIgnoreCase("i")){
              i++;
            }
            if(v[j].equalsIgnoreCase("o")){
              o++;
            }
            if(v[j].equalsIgnoreCase("u")){
              u++;
            }
            
        }

        System.out.printf("Quantidade de letras a = %d%nQuantidade de letras e = %d%nQuantidade de letras i = %d%nQuantidade de letras o = %d%nQuantidade de letras u = %d%n",a,e,i,o,u);
    }
}
