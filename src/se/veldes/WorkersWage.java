package se.veldes;

import java.util.ArrayList;
import java.util.List;

public class WorkersWage {

    public static void main(String[] args) {
        /*
        Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
        Output: 30.66667
        Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.
         */
        System.out.println(new WorkersWage().mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {


        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++)
            workers.add(new Worker(wage[i], quality[i]));

        return 0.0;

    }

    private class Worker implements Comparable<Worker> {
        private int wage;
        private int quality;

        private double ratio;

        private Worker(int wage, int quality) {
            this.wage = wage;
            this.quality = quality;
            this.ratio = (double) quality / (double) wage;
        }


        @Override
        public int compareTo(Worker worker) {

            return Double.compare(this.ratio, worker.ratio);
        }
    }
}
