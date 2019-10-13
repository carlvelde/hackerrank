package se.veldes;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourglassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
  /*
        Hourglass patter is
        x0y0, x1y0, x2y0,
            x1y1,
        x0y2, x1y2, x2y2
        while x+2 < arr[y][length] and y+2 < arr.length
         */

        int largestHourGlassSum = Integer.MIN_VALUE;

        // Loop y
        for(int curY = 0; curY+2 < arr.length; curY++) {
            for(int curX = 0; curX+2 < arr[curY].length; curX++) {
                int hourGlassSum = getHourGlasSum(arr, curY, curX);
                System.out.println(hourGlassSum);
                if(hourGlassSum > largestHourGlassSum)
                    largestHourGlassSum = hourGlassSum;
            }

        }

        return largestHourGlassSum;

    }

    static int getHourGlasSum(int[][] arr, int yOffset, int xOffset) {
        if(!(yOffset+2 < arr.length))
            throw new RuntimeException("Offset y was oob: "+yOffset);
        if(!(xOffset+2 < arr[yOffset].length))
            throw new RuntimeException("Offset x was oob: "+xOffset);

        int row1Sum =  arr[yOffset][xOffset] + arr[yOffset][xOffset+1] + arr[yOffset][xOffset+2];
        int row3Sum = arr[yOffset+2][xOffset] + arr[yOffset+2][xOffset+1] + arr[yOffset+2][xOffset+2];

        return row1Sum+arr[yOffset+1][xOffset+1]+row3Sum;

    }


    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];

        /*


-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5



         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("-1 -1 0 -9 -2 -2");
        arrayList.add("-2 -1 -6 -8 -2 -5");
        arrayList.add("-1 -1 -1 -2 -3 -4");
        arrayList.add("-1 -9 -2 -4 -4 -5");
        arrayList.add("-7 -3 -3 -2 -9 -9");
        arrayList.add("-1 -3 -1 -2 -4 -5");

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = arrayList.get(i).split(" ");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        System.out.println(hourglassSum(arr));

    }
}
