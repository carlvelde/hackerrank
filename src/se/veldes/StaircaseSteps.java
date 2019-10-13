package se.veldes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaircaseSteps {

    static int stepPerms(int n) {

        if(n < 0)
            return 0;
        else if(n == 0)
            return 1;
        System.out.println(n);

        return stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3);

    }

    public static void main(String[] args) {

        int perms = stepPerms(5);
        System.out.println(perms);

    }
}
