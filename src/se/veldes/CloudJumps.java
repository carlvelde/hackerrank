package se.veldes;

public class CloudJumps {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int jumps = 0;
        int curPos = 0;
        for(int i=1; curPos < c.length-1; i++) {
            // Check two steps
            if(curPos + 2 < c.length && c[curPos + 2] == 0) {
                jumps++;
                curPos = curPos + 2;
                i++;
            } else {
                // Not end, not two, assume one
                curPos++;
                jumps++;
            }
        }
        return jumps;

    }


    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
    }
}
