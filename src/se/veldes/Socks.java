import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Socks {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int matchingPairs = 0;
        HashSet<Integer> odds = new HashSet<>();
        // Loop the socks, check if we have a odd matching. If match remove odd and count a pair
        for(int i=0; i < ar.length; i++) {
            if(odds.contains(ar[i])){
                odds.remove(ar[i]);
                matchingPairs++;
            } else {
                odds.add(ar[i]);
            }
        }
        return matchingPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] socks = {10,20,10,80,80,6};

        System.out.println(sockMerchant(0,socks));
    }
}
