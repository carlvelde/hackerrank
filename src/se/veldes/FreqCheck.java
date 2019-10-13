package se.veldes;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FreqCheck {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {

        final int ADD = 1;
        final int DEL = 2;
        final int CHECK = 3;

        Map<Integer,Integer> values = new HashMap<>();
        Map<Integer,Integer> freqIndex = new HashMap<>();
        List<Integer> freq = new ArrayList<>();

        for(int[] q : queries) {
            Integer curVal = values.get(q[1]);
            Integer newVal = null;
            if(q[0] == ADD) {
                if(curVal == null)
                    newVal = 1;
                else
                    newVal = curVal+1;
                index(freqIndex,curVal,newVal);
                values.put(q[1],newVal);
            } if(q[0] == DEL) {
                if(curVal != null) {
                    if(curVal < 2) {
                        values.remove(q[1]);
                        index(freqIndex,curVal,0);
                    }
                    else {
                        values.put(q[1], curVal - 1);
                        index(freqIndex, curVal,curVal - 1);
                    }
                }
            } if(q[0] == CHECK) {
                if(q[1] == 1)
                    System.out.println("WTF");
                Integer c = freqIndex.get(q[1]);
                freq.add((c != null && c != 0)? 1:0);
            }
        }
        return freq;

    }

    /**
     * Update index the right value of curVal and newVel
     * @param freqIndex
     * @param curVal
     * @param newVal
     */
    static void index(Map<Integer,Integer> freqIndex, Integer curVal, Integer newVal) {
        // Decrease curVal by 1
        freqIndex.computeIfPresent(curVal, (key, val) -> val - 1);

        // Increase newVal by one
        freqIndex.compute(newVal, (key, val) -> (val == null)? 1:val+1);

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/carlvelde/IdeaProjects/hackerrank/src/freqCheckInput13.txt"))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/carlvelde/IdeaProjects/hackerrank/src/freqCheckOut.txt"))) {
                bufferedWriter.write(
                        ans.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n");
            }
        }
    }
}
