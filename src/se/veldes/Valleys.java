package se.veldes;

public class Valleys {

    static int countingValleys(int n, String s) {

        int alt = 0; // Always starts at sealvl
        int valleyCount = 0;
        char[] steps = s.toCharArray();

        // Adjust altitude for each step, if we go below 0 we entered a valley, if we go >= 0 we exited
        for(int i=0; i < steps.length; i++) {
            if(steps[i] == 'D' && alt == 0)
                valleyCount++;
            alt = (steps[i] == 'D') ? alt-1 : alt+1;
        }
        return valleyCount;


    }
}
