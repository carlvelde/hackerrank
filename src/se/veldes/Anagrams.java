package se.veldes;

import java.util.*;

public class Anagrams {


    static int sherlockAndAnagrams(String s) {
        // Create all possible substr from s
        ArrayList<String> allSubs = new ArrayList<>();
        ArrayList<Integer> pairCount = new ArrayList<>();
        for(int i=0; i < s.length(); i++) {
            for(int j=i+1; j <= s.length(); j++) {
                if(!(i==0 && j == s.length()))
                    allSubs.add(s.substring(i,j));
                    pairCount.add(0);
            }
        }
        int count = 0;
        for(int i=0; i < allSubs.size(); i++) {
            for(int j=0; j < allSubs.size(); j++) {
                if(j!=i && isAnagram(allSubs.get(i),allSubs.get(j))) {
                    int iCount = pairCount.get(i);
                    int jCount = pairCount.get(j);
                    if(iCount < 2 && jCount < 2) {
                        count++;
                        pairCount.set(i,iCount+1);
                        pairCount.set(j,jCount+1);
                    }

                }

            }

        }
        return count;

    }


    static boolean isAnagram(String s1, String s2) {
        if(s1 == null || s1.length() == 0)
            throw new IllegalArgumentException("s1 was null or empty");
        if(s2 == null || s2.length() == 0)
            throw new IllegalArgumentException("s2 was null or empty");

        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        /*
        for(int i=0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(s2.length()-1-i))
                return false;
        }
         */
        return s1.equals(new StringBuilder(s2).reverse().toString());

    }

    /*
    abcd    abcd a

    abba    abba    a       0   X       JA
    abba    abba    ba      0   X
    abba    abba    bba     0   X
    abba    abba    abba    0
    abba    bba     b       1   X
    abba    bba     bb      1
    abba    bba     abb     1
    abba    ba      b       2
    abba    ba      ab      2
    abba    a       a
     */

    public static void main(String[] args) {

        //System.out.println(isAnagram("abba", "abba")+" abba");
        //System.out.println(isAnagram("abb", "bba")+" abb");
        //System.out.println(isAnagram("ab", "ba")+" ab");
        //System.out.println(isAnagram("a", "a")+" a");

        //System.out.println(sherlockAndAnagrams("abba")+" : 4");
        //System.out.println(sherlockAndAnagrams("abcd")+" : 0");
        //System.out.println(sherlockAndAnagrams("ifailuhkqq")+" : 3");
        System.out.println(sherlockAndAnagrams("kkkk")+" : 10");
        System.out.println(sherlockAndAnagrams("mom")+" : 3");
    }
}
