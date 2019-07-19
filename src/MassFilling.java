package homeWorks.homeWork6;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.sort;

public class MassFilling {

    @filled
    public int[] sortedMassive(int[] mass) {
        sort(mass);
        return mass;
    }

    @filled
    public int[] sortedMassiveWirhRndElement(int[] mass) {
        sort(mass);
        int[] ressMass = new int[mass.length + 1];
        for (int i = 0; i < mass.length; i++) {
            ressMass[i] = mass[i];
        }
        ressMass[ressMass.length - 1] = (int) ((Math.random() * 100) + 5);
        return ressMass;
    }

    @filled
    public int[] sinkSortedMassive(int [] mass){
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass.length - 1 - i; j++) {
                if (mass[j] < mass[j + 1]) {
                    int buff = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = buff;
                }
            }
        }

        return mass;
    }

    @filled
    public int [] randomMassive(int [] mass){
       Collections.shuffle(Arrays.asList(mass));
       return mass;
    }
}


