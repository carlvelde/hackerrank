package se.veldes;

import java.util.ArrayList;

public class FindKthLargest {

    public static void main(String[] args) {

        // [3,2,3,1,2,4,5,5,6]
        //4

        // [5,2,4,1,3,6,0]
        //4

        System.out.println(new FindKthLargest().findKthLargest(new int[]{5, 2, 4, 1, 3, 6, 0}, 4));
    }

    public int findKthLargest(int[] nums, int k) {

        ArrayList<Integer> bigNums = new ArrayList<>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (bigNums.size() == 0) // Empty just insert
                bigNums.add(nums[i]);
            else {
                boolean added = false;
                for (int j = 0; j < bigNums.size(); j++) {
                    if (nums[i] > bigNums.get(j)) {
                        bigNums.add(j, nums[i]);
                        added = true;
                        break;
                    }
                }
                if (bigNums.size() < k && !added)
                    bigNums.add(nums[i]);
                else if (bigNums.size() > k)
                    bigNums.remove(bigNums.size() - 1);
            }

        }

        return bigNums.get(k - 1);


    }
}
