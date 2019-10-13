package se.veldes;

public class BankNotification {



    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;

        for(int i=d; i < expenditure.length; i++) {

            double median = nlogn_findMedian(expenditure, expenditure.length/2, i-d,1);
            if(expenditure[i] >= (median * 2) )
                notifications++;
        }
        return  notifications;

    }

    public static double nlogn_findMedian(int a[], int pos, int left, int right)
    {
        int[] subArray = java.util.Arrays.copyOfRange(a, left,right);
        java.util.Arrays.sort(subArray);

        // check for even case
        if (subArray.length % 2 != 0)
            return (double)subArray[subArray.length / 2];

        return (double)(subArray[(subArray.length - 1) / 2] + subArray[subArray.length / 2]) / 2.0;
    }

    private static int quickSelect_Median(int[] array, int pos, int left, int right) {
        if (left == right && left == pos) {
            return array[left];
        }
        int posRes = partition(array, left, right, pos);
        if (posRes == pos) {
            return array[posRes];
        } else if (posRes < pos) {
            return quickSelect_Median(array, pos, posRes + 1, right);
        } else {
            return quickSelect_Median(array, pos, left, posRes - 1);
        }
    }

    private static int partition(int[] array, int left, int right, int pos) {
        int pivot = array[left];
        int position = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] <= pivot) {
                position++;
                swap(array, i, position);
            }
        }
        swap(array, left, position);
        return position;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[]{10,20,30,40,50},3)+ "(expect 1 )");
        System.out.println(activityNotifications(new int[]{2,3,4,2,3,6,8,4,5},5)+ "(expect 2 )");
        System.out.println(activityNotifications(new int[]{1,2,3,4,4},4)+ "(expect 0 )");


    }
}
