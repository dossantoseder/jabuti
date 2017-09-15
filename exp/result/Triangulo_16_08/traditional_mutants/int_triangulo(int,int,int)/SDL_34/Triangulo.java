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
                if (a != b && b != c) {
                    as = a * a;
                    bs = b * b;
                    cs = c * c;
                    if (as == bs + cs) {
                        classe = 3;
                        area = b * c / 2;
                    } else {
                        s = (a + b + c) / 2;
                        area = Math.sqrt( s * ((s - a) * ((s - b) * (s - c))) );
                        if (as < bs + cs) {
                            classe = 4;
                        } else {
                            if (as > bs + cs) {
                                classe = 5;
                            }
                        }
                    }
                } else {
                    if (a == b && b == c) {
                        classe = 1;
                        area = a * a * Math.sqrt( 3 ) / 4;
                    } else {
                        classe = 2;
                        if (a == b || a == c || b == c) {
                            s = a + b + c / 2;
                            area = Math.sqrt( s * ((s - a) * ((s - b) * (s - c))) );
                        }
                    }
                }
            } else {
                classe = 0;
                area = 0;
            }
        }
        return 0;
    }

}
