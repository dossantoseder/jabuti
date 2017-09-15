// This is a mutant program.
// Author : ysma

public class Triangulo
{

    public static  int triangulo( int a, int b, int c )
    {
        int classe = -2;
        double area;
        double as;
        double bs;
        double cs;
        double s;
        if (a < b || a < c || b < c) {
            classe = -1;
        } else {
            if (a < b + c && b < a + c && c < a + b) {
            } else {
                classe = 0;
                area = 0;
            }
        }
        return classe;
    }

}
