package se.veldes;

public class BubbleSort {

    static void countSwaps(int[] a) {

        int swaps = 0;

        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swaps++;
                }
            }
        }

        printResult(swaps, a);

    }


    private static void printResult(int swaps, int[] a) {

        System.out.printf("Array is sorted in %d swaps.%n", swaps);
        System.out.printf("First Element: %d%n", a[0]);
        System.out.printf("Last Element: %d%n", a[a.length - 1]);

    }

    public static void main(String[] args) {

        countSwaps(new int[]{9, 6, 7, 5, 4, 1, 2, 3});

    }
}
