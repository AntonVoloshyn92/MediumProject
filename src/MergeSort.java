public class MergeSort {

    public int[] sort(int[] mass) {
        int   halfMassValue = mass.length / 2;
        int[] mass1         = new int[halfMassValue];
        int[] mass2         = new int[mass.length - halfMassValue];

        for (int i = 0; i < halfMassValue; i++) {
            mass1[i] = mass[i];
        }

        for (int i = halfMassValue; i < mass.length; i++) {
            mass2[i] = mass[i];
        }

        int[] result = new int[mass.length];

        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {

            if (i > mass1.length - 1) {
                int a = mass2[j];
                result[k] = a;
                j++;
            } else if (j > mass2.length - 1) {
                int a = mass1[i];
                result[k] = a;
                i++;
            } else if (mass1[i] < mass2[j]) {
                int a = mass1[i];
                result[k] = a;
                i++;
            } else {
                int b = mass2[j];
                result[k] = b;
                j++;
            }
        }

        return result;
    }


}
