package se.veldes;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hej igen!");

	    int[] minaNummer = new int[10];

	    for(int i=0; i < minaNummer.length; i++) {
	        minaNummer[i] = i;
        }

	    minaNummer = shiftLeft(minaNummer,3);


	    for(int i=0; i < minaNummer.length; i++) {
	        System.out.println(minaNummer[i]);
        }



    }

    public static int[] shiftLeft(int[] a, int d) {
        for(int step=0; step < d; step++) {
            int firstArrVal = a[0];
            for (int i = 1; i < a.length; i++) {
                a[i - 1] = a[i];
            }
            a[a.length - 1] = firstArrVal;
        }
        return a;
    }
}
