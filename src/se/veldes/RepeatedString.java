package se.veldes;

public class RepeatedString {


    static long repeatedString(String s, long n) {
        if(s.equals("") || n == 0 || !s.contains("a"))
            return 0;

        long count = 0;
        // s is "infinite"

        // check the number of times 'a' exist in s
        for(long i=0; i < n; i++) {
            for(char c : s.toCharArray()) {
                if(c == 'a')
                    count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba",10));
    }
}
