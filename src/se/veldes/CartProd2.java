package se.veldes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartProd2 {

    private static <E> List<List<E>> getProduct(List<List<E>> input) {

        List<List<E>> products = new ArrayList<>();
        // Create a bucket that holds the current created product
        List<E> current = new ArrayList<>();
        for(int i=0; i<input.size(); i++)
            current.add(null);


       _getProduct(input,products, current,0);

       return products;

    }

    private static <T> void _getProduct(List<List<T>> input, List<List<T>>  products, List<T> current, int k) {

        if(k == input.size()) {
            products.add(new ArrayList<>(current));
        } else {
            for(int j = 0; j < input.get(k).size(); j++) {
                current.set(k, input.get(k).get(j));
                _getProduct(input, products, current, k + 1);
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> prod = getProduct(Arrays.asList(Arrays.asList("a", "b", "c"),
                Arrays.asList("1", "2"),
                Arrays.asList("Z", "X", "Y")));
        prod.forEach(System.out::println);

    }

}
