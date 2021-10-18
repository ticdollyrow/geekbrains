package gb.algorithms.recursion;

public class Exponentiation{
    public static double pow(double number, int exponent){
        if(exponent == 0) return 1;
        if(exponent == 1) return  number;
        if(exponent < 0 ) {
            exponent *= -1;
            return 1/( number*pow(number, exponent - 1));
        }
        return number*pow(number, exponent - 1);
    }
}
