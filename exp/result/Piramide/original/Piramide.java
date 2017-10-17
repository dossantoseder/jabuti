// This is a mutant program.
// Author : ysma

public class Piramide
{

    public static  int piramide( int base1, int base2, int base3, int l1, int l2, int l3 )
    {
        int classe = 1;
        if (base1 > 0 && base1 <= 15 && (base2 > 0 && base2 <= 15) && (base3 > 0 && base3 <= 15) && (l1 > 0 && l1 <= 15) && (l2 > 0 && l2 <= 15) && (l3 > 0 && l3 <= 15)) {
            if (base1 < base2 || base1 < base3 || base2 < base3) {
                classe = -4;
            } else {
                if (base1 < base2 + base3) {
                    if (base1 == base2 && base2 == base3) {
                        if (base1 < l1 || base1 < l2 || l1 < l2) {
                            classe = -3;
                        } else {
                            if (base1 < l1 + l2) {
                                if (base1 == l1 && l1 == l2) {
                                    if (l1 < l3) {
                                        classe = -7;
                                    } else {
                                        if (l1 == l3) {
                                            classe = 3;
                                        } else {
                                            classe = -8;
                                        }
                                    }
                                } else {
                                    classe = -6;
                                }
                            } else {
                                classe = -5;
                            }
                        }
                    } else {
                        classe = -2;
                    }
                } else {
                    classe = -1;
                }
            }
        } else {
            classe = -9;
        }
        return classe;
    }

}
