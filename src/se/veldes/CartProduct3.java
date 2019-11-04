package se.veldes;

import java.util.ArrayList;
import java.util.List;

public class CartProduct3 {


    public static void main(String[] args) {

        List<List<String>> strings = new ArrayList<>();
        strings.add(new ArrayList<>());
        strings.add(new ArrayList<>());
        strings.add(new ArrayList<>());

        strings.get(0).add("a");
        strings.get(0).add("b");
        strings.get(0).add("c");
        strings.get(1).add("1");
        strings.get(1).add("2");
        strings.get(1).add("3");
        strings.get(2).add("X");
        strings.get(2).add("Y");

        System.out.println(cartProd(strings));
    }

    private static List<String> cartProd(List<List<String>> strings) {
        ArrayList<String> products = new ArrayList<>();

        // Bucket a -> recurse +1 -> bucket a1 -> recurse +1 -> bucket a1x -> recurse +1 -> add bucket to prod

        List<String> bucket = new ArrayList<>(strings.size());

        for (int i = 0; i < strings.size(); i++) {
            bucket.add(null);
        }
        _cartProd(strings, products, bucket, 0);

        return products;

    }

    private static void _cartProd(List<List<String>> strings, List<String> products, List<String> bucket, int k) {
        if (strings.size() == k) {
            StringBuilder sb = new StringBuilder(strings.size());
            for (String s : bucket)
                sb.append(s);
            products.add(sb.toString());
        } else {
            for (int i = 0; i < strings.get(k).size(); i++) {
                bucket.set(k, strings.get(k).get(i));
                _cartProd(strings, products, bucket, k + 1);
            }
        }
    }
}
