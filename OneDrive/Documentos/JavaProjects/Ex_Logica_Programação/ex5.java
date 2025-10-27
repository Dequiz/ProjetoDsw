
import java.util.HashMap;


public class ex5 {
    public static void main(String[] args) {
        HashMap<String,Integer> alunos = new HashMap<String,Integer>();

        alunos.put("Ana", 8);
        alunos.put("Bruno", 7);
        alunos.put("Carla", 5);

        for(String item : alunos.keySet()){
          if(alunos.get(item) > 6){
           System.out.printf("%s: %d%n",item,alunos.get(item));
          }
        }
        
}
}