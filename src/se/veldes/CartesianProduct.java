package se.veldes;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartesianProduct {

    public List<?> product(List<?>... a) {
        if (a.length >= 2) {
            List<?> product = a[0];
            for (int i = 1; i < a.length; i++) {
                product = product(product, a[i]);
            }
            return product;
        }

        return emptyList();
    }

    private <A, B> List<?> product(List<A> a, List<B> b) {
        return of(a.stream()
                .map(e1 -> of(b.stream().map(e2 -> asList(e1, e2)).collect(toList())).orElse(emptyList()))
                .flatMap(List::stream)
                .collect(toList())).orElse(emptyList());
    }


    public static void main(String[] args) {


        List<?> prod = new CartesianProduct().product(
                Arrays.asList("a","b","c"),
                Arrays.asList("1","2"),
                Arrays.asList("Z","X","Y"));
        prod.forEach(System.out::println);
    }


}