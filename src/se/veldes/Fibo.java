package se.veldes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * fib(n) = fib(n-1) + fib(n-2)
 *
 * 1   2   3   4   5    6    7
 * 0   1   1   2   3    5    8
 *
 * fib(4) = fib(4-1) 3 + fib(4-2) 2;
 */
public class Fibo {

    public static int fibonacci2(int n) {

        if(n == 0)
            return 0;
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        if(n == 3)
                return 1;
        return _fibonacci2(n,3,1,1);
    }

    private static int _fibonacci2(int n, int i, int num1, int num2) {
        int fib = num1 + num2;
        System.out.println(i+"="+fib);
        if(n == i)
            return fib;
        else return _fibonacci2(n,i+1,num2,fib);
    }

    private static final Map<Integer, Integer> mem = new HashMap<>();

    public static int fibM(int n) {

        Integer result = mem.get(n);
        if(result != null)
            return result;
        else if(n == 0)
            result = 0;
        else if(n == 1)
            result =  0;
        else if(n == 2)
            result =  1;
        else if(n == 3)
            result =  1;
        else result = fibM(n-1) + fibM(n-2);

        mem.put(n,result);
        System.out.println(n +"="+result);

        return result;

    }

    public static int fib(int n) {
        int result;
        if(n == 0)
            result = 0;
        else if(n == 1)
            result =  0;
        else if(n == 2)
            result =  1;
        else if(n == 3)
            result =  1;
        else result = fib(n-1) + fib(n-2);

        System.out.println(n +"="+result);

        return result;

    }




    public static void main(String[] args) {
        int fibI = fibonacci2(30);
            System.out.println("----");
            System.out.println(fibI);
    }
}
