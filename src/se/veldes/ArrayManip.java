package se.veldes;

public class ArrayManip {

    // Complete the arrayManipulation function below.
    static long arrayManipulationSlow(int n, int[][] queries) {
        long max = 0;

        long[] arr = new long[n];

        for (int[] query : queries) {
            for (int i = query[0] - 1; i < query[1]; i++) {
                arr[i] = arr[i] + query[2];
                max = Math.max(arr[i], max);
            }
        }

        return max;

    }
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;

        //This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
        long[] arr = new long[n];

        int lower;
        int upper;
        long sum;

        for(int i=0;i<n;i++) arr[i]=0;

        for (int[] query : queries) {
            lower = query[0];
            upper = query[1];
            sum = query[2];

            arr[lower-1]+=sum;
            if(upper<n) arr[upper]-=sum;
        }


        long temp=0;

        for(int i=0;i<n;i++){
            temp += arr[i];
            if(temp> max) max=temp;
        }



        return max;

    }

    public static void main(String[] args){
        int n = 10;

        /*10 4
2 6 8
3 5 7
1 8 1
5 9 15

         */
        int[][] queries = new int[][]{
                {2,6,8},
                {3,5,7},
                {1,8,1},
                {5,9,15}
        };

        System.out.println(arrayManipulation(n,queries));
    }
}
