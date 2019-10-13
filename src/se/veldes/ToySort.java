package se.veldes;

public class ToySort {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {

        java.util.Arrays.sort(prices);

        int toys = 0;
        int sum = 0;
        for (int price : prices) {
            if (sum + price > k) {
                return toys;
            } else {
                sum += price;
                toys++;

            }
        }
        return toys;

    }

}
