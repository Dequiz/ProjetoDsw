public class Calculadora {
    public int soma(int a, int b) {
        return a + b;
    }
    public float soma(float a, float b) {
        return a + b;
    }
    public int soma(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

public static void main(String[] args) {
    Calculadora calc = new Calculadora();
    System.out.println(calc.soma(5, 10));          
    System.out.println(calc.soma(5.5f, 10.2f));   
    System.out.println(calc.soma("5", "10"));     
}
}
