package gapInPrimes;

// https://www.codewars.com/kata/561e9c843a2ef5a40c0000a4

public class GapInPrimes {

    public static boolean primeNums(long a)
    {
        if(a < 2) { return false; }
        else if(a == 2 || a == 3) { return true; }

        for(int i = 2; i * i <= a; i++)
        {
            if(a % i == 0) { return false; }
        }

        return true;
    }

    public static long[] gap(int g, long m, long n)
    {
        long a = 0; long b = 0;
        long [] result = new long[2];

        for(long i = m; i <= n; i++)
        {
            if(primeNums(i))
            {
                if(a == 0) { a = i; }
                else { b = i; }
            }
            if(a != 0 && b != 0)
            {
                if (b - a == g)
                {
                    result[0] = a;
                    result[1] = b;
                    return result;
                }
                else
                {
                    a = b;
                    b = 0;
                }
            }
        }

        return null;
    }


}
