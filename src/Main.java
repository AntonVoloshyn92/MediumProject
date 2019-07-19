package homeWorks.homeWork6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        int[] mass = new int[(int) (Math.random() * 100)];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) (Math.random() * 100);
        }

        long[][] massResalt = new long[4][7];

        Class classMassives = MassFilling.class;
        Class classResf     = Sort.class;

        Method[] sortMethods    = classResf.getDeclaredMethods();
        Method[] fillingMethods = classMassives.getDeclaredMethods();

        List<Method> annotatedSortMethod  = new ArrayList<>();
        List<Method> annotatedFillMethods = new ArrayList<>();

        for (Method sortMethod : sortMethods) {
            if (sortMethod.isAnnotationPresent(sorted.class)) {
                annotatedSortMethod.add(sortMethod);
            }
        }

        for (Method fillingMethod : fillingMethods) {
            if (fillingMethod.isAnnotationPresent(filled.class)) {
                annotatedFillMethods.add(fillingMethod);
            }
        }

        for (int i = 0; i < annotatedFillMethods.size(); i++) {
            int[] progressMass = (int[]) annotatedFillMethods.get(i).invoke(classMassives.newInstance(), mass.clone());
            massResalt[i][0] = progressMass.length;

            for (int j = 0; j < annotatedSortMethod.size(); j++) {
                long timeSort = (long) annotatedSortMethod.get(j).invoke(classResf.newInstance(), progressMass);
                massResalt[i][j + 1] = timeSort;

            }
        }

        for (long[] vekror1 : massResalt) {
            for (long vektor2 : vekror1) {
                System.out.print(vektor2 + " ");
            }
            System.out.println();
        }
    }
}


