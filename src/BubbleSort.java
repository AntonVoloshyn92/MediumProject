public class BubbleSort {


    public int[] sortFloat(int[] mass) {
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass.length - 1 - i; j++) {
                if (mass[j] > mass[j + 1]) {
                    int buff = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = buff;
                }
            }
        }

        return mass;
    }

    public int[] sortSink(int[] mass) {
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
}
