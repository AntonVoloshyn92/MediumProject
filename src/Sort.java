package homeWorks.homeWork6;

import java.util.Arrays;

public class Sort {
    @sorted
    public long ArraysSort(int[] mass) {
        long sortStart = System.nanoTime();

        Arrays.sort(mass);

        return System.nanoTime() - sortStart;
    }

    @sorted
    public long sortFloat(int[] mass) {
        long sortStart = System.nanoTime();

        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass.length - 1 - i; j++) {
                if (mass[j] > mass[j + 1]) {
                    int buff = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = buff;
                }
            }
        }

        return System.nanoTime() - sortStart;
    }

    @sorted
    public long sortSink(int[] mass) {
        long sortStart = System.nanoTime();

        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass.length - 1 - i; j++) {
                if (mass[j] < mass[j + 1]) {
                    int buff = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = buff;
                }
            }
        }
        return System.nanoTime() - sortStart;
    }

    @sorted
    public long insertSort(int[] mass) {
        long sortStart = System.nanoTime();

        for (int i = 0; i < mass.length - 1; i++) {
            int buff = mass[i];
            int j    = i;
            while (j > 0 && mass[j - 1] > buff) {
                mass[j] = mass[j - 1];
                j = j - 1;
                mass[j] = buff;
            }
        }
        return System.nanoTime() - sortStart;
    }

    @sorted
    public long mergeSort(int[] A) {
        long sortStart = System.nanoTime();

        if (A.length > 1) {
            int   q          = A.length / 2;
            int[] leftArray  = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A, q + 1, A.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            A = mergeSort(leftArray, rightArray);
        }

        return System.nanoTime() - sortStart;
    }

    int[] mergeSort(int[] l, int[] r) {
        int   totElem = l.length + r.length;
        int[] a       = new int[totElem];
        int   i, li, ri;
        i = li = ri = 0;
        while (i < totElem) {
            if ((li < l.length) && (ri < r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                } else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            } else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        return a;

    }

    int[] quickSort(int[] array, int low, int high) {
        long sortStart = System.nanoTime();

        if (array.length == 0)
            return null;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return null;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
        return array;
    }

    @sorted
    public long quickSort(int[] array){
        long sortStart = System.nanoTime();

        quickSort(array, 0, array.length-1);

        return System.nanoTime() - sortStart;
    }
}
