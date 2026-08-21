public class MatematicaReinventada
{
    public static boolean isNegativo (int a, int d)
    {
        if (a==0) return true;
        if (d==0) return false;

        return MatematicaReinventada.isNegativo(++a,--d);
    }

    public static boolean isNegativo (int x)
    {
        if (x==0) return false;

        return MatematicaReinventada.isNegativo(x,x);
    }


    // 2 + 2 -> 3 + 1 -> 4 + 0
    public static int somar (int a, int b)
    {
        if (MatematicaReinventada.isNegativo(b))
            return MatematicaReinventada.somar(--a,++b);
        if (b==0) return a;

        return MatematicaReinventada.somar(++a,--b);
    }

    // 4 - 2 -> 3 - 1 -> 2 - 0
    public static int subtrair (int a, int b)
    {
        if (MatematicaReinventada.isNegativo(b))
        {
            if (MatematicaReinventada.isNegativo(a))
                return MatematicaReinventada.subtrair(++a,++b);

            return MatematicaReinventada.subtrair(--a,++b);
        }

        if (b==0) return a;

        return MatematicaReinventada.subtrair(--a,--b);
    }


    // módulo de -3 -> módulo de -2 -> módulo de -1 -> módulo de 0
    public static int modulo (int a)
    {
        if (MatematicaReinventada.isNegativo(a))
            return MatematicaReinventada.somar(1,modulo(++a));

        return a;
    }


    // m(3,-4) -> m(3,-3) -> m(3,-2) -> m(3,-1) -> m(3,0)
    public static int multiplicacao (int a, int b)
    {
        if (b==0) return 0;
        if (a==0) return 0;

        if (MatematicaReinventada.isNegativo(b))
        {
            if (MatematicaReinventada.isNegativo(a))
                return MatematicaReinventada.multiplicacao(MatematicaReinventada.modulo(a),MatematicaReinventada.modulo(b));

            return MatematicaReinventada.somar(MatematicaReinventada.multiplicacao(a,b),++b);
        }

        return MatematicaReinventada.somar(multiplicacao(a,--b),a);
    }


    // p(3,3) -> p(3,2) -> p(3,1) -> p(3,0)
    public static int potencia (int a, int b)
    {
        if (b==0) return 1;

        return MatematicaReinventada.multiplicacao(a,MatematicaReinventada.potencia(a,--b));
    }


    // d(10,3) -> d(7,3) -> d(4,3) -> d(1,3)
    public static int divisao (int a, int b)
    {
        if (MatematicaReinventada.isPrimeiroMenor(a,b))
            return 0;

        if (MatematicaReinventada.isNegativo(a))
        {
            if (MatematicaReinventada.isNegativo(b))
                return MatematicaReinventada.divisao(MatematicaReinventada.modulo(a),MatematicaReinventada.modulo(b));

            return MatematicaReinventada.subtrair(0,MatematicaReinventada.divisao(MatematicaReinventada.modulo(a),b));
        }

        if (MatematicaReinventada.isNegativo(b))
            return MatematicaReinventada.subtrair(0,MatematicaReinventada.divisao(a,MatematicaReinventada.modulo(b)));

        return MatematicaReinventada.somar(1,MatematicaReinventada.divisao(MatematicaReinventada.subtrair(a,b),b));
    }


    public static int resto (int a, int b)
    {
        return MatematicaReinventada.subtrair(a,MatematicaReinventada.multiplicacao(MatematicaReinventada.divisao(a,b),b));
    }


    public static boolean isPrimeiroMenor (int a, int b)
    {
        if (MatematicaReinventada.isNegativo(MatematicaReinventada.subtrair(a,b)))
        {
            if (MatematicaReinventada.isNegativo(a))
            {
                if (MatematicaReinventada.isNegativo(b))
                    return MatematicaReinventada.isPrimeiroMenor(a,++b);
            }
            return true;
        }
        return false;
    }


    public static boolean isPrimeiroMenorIgual (int a, int b)
    {
        if (a==b) return true;

        return MatematicaReinventada.isPrimeiroMenor(a,b);
    }


    public static boolean isPrimeiroMaior (int a, int b)
    {
        if (a==b) return false;

        if (MatematicaReinventada.isNegativo(MatematicaReinventada.subtrair(a,b)))
        {
            if (MatematicaReinventada.isNegativo(a))
            {
                if (MatematicaReinventada.isNegativo(b))
                    return MatematicaReinventada.isPrimeiroMaior(++a,b);

                return false;
            }
            return false;
        }
        return true;
    }


    public static boolean isPrimeiroMaiorIgual (int a, int b)
    {
        if (a==b) return true;

        return MatematicaReinventada.isPrimeiroMaior(a,b);
    }


    public static boolean isDiferente (int a, int b)
    {
        if (a==b) return false;

        return true;
    }
}
