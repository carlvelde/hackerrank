package se.veldes;

import java.util.HashMap;
import java.util.Map;

public class Rotate2DArray {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] a1 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        // rotate(a1, 3) should return:
        // [[7, 4, 1],
        //  [8, 5, 2],
        //  [9, 6, 3]]

        int[][] a2 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        // rotate(a2, 4) should return:
        // [[13, 9, 5, 1],
        //  [14, 10, 6, 2],
        //  [15, 11, 7, 3],
        //  [16, 12, 8, 4]]


        printMatrix(rotateAuxn(a1, 3));

        int[][] a2rotated = rotateAuxn(a2, 4);
        printMatrix(a2rotated);
    }

    private static void printMatrix(int[][] a2rotated) {
        for (int[] row : a2rotated) {
            for (int col : row)
                System.out.print(col + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println("----");
    }

    // Implement your solution below.
    public static int[][] rotateNew(int[][] a, int n) {
        // NOTE: To solve it in place, write this function so that you
        // won't have to create rotated.
        int[][] rotated = new int[n][n];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                rotated[j][n - 1 - i] = a[i][j];
            }
        }
        return rotated;
    }

    /*
    O(n) with auxSpace(n)
     */
    public static int[][] rotateAuxn(int[][] a, int n) {

        Map<Integer, Map<Integer, Integer>> oldValues = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int oldVal = a[j][n - 1 - i];
                int[] oldKey = new int[]{j, n - 1 - i};

                int newVal = (map2dcontains(oldValues, i, j)) ? oldValues.get(i).remove(j) : a[i][j];

                if (!oldValues.containsKey(oldKey[0]))
                    oldValues.put(oldKey[0], new HashMap<>());
                oldValues.get(oldKey[0]).put(oldKey[1], oldVal);

                a[j][n - 1 - i] = newVal;

            }
            printMatrix(a);
        }
        return a;
    }

    private static boolean map2dcontains(Map<Integer, Map<Integer, Integer>> map, int k1, int k2) {
        if (map.containsKey(k1))
            return map.get(k1).containsKey(k2);
        return false;
    }

    public static int[][] rotate(int[][] a, int n) {
        // n/2 gives us floor(n/2)
        // and n/2 + n%2 gives us ceiling(n/2)
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int currentI = i;
                int currentJ = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = a[currentI][currentJ];
                    int[] newCoordinates = rotateSub(currentI, currentJ, n);
                    currentI = newCoordinates[0];
                    currentJ = newCoordinates[1];
                }
                for (int k = 0; k < 4; k++) {
                    a[currentI][currentJ] = tmp[(k + 3) % 4];
                    int[] newCoordinates = rotateSub(currentI, currentJ, n);
                    currentI = newCoordinates[0];
                    currentJ = newCoordinates[1];
                }
                printMatrix(a);
            }

        }
        return a;
    }

    public static int[] rotateSub(int i, int j, int n) {
        int[] newCoordinates = new int[2];
        newCoordinates[0] = j;
        newCoordinates[1] = n - 1 - i;
        return newCoordinates;
    }


}
