package se.veldes;

import java.util.ArrayList;
import java.util.TreeSet;

public class MedianFinder {

    /*
    Holds 1 2 3 4 5
     */
    private TreeSet<Integer> set = new TreeSet<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(7);
        System.out.println(mf.findMedian());
        mf.addNum(8);
        System.out.println(mf.findMedian());
        mf.addNum(9);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
    }

    public void addNum(int num) {
        set.add(num);
        if (set.size() == 5) {
            set.pollFirst();
            set.pollLast();
        }
    }

    public double findMedian() {
        /*
    Set might be  1 2 3 4
                  1 2 3
                  1 2
                  1
     */
        ArrayList<Integer> merArr = new ArrayList<>(set);
        int n = merArr.size();
        if (n % 2 != 0)
            return (double) merArr.get(n / 2);
        else
            return (double) (merArr.get((n - 1) / 2) + merArr.get(n / 2)) / 2.0;
        // (    a[(n - 1) / 2]  +    a[n / 2]   )                      / 2.0

    }
}
