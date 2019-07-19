import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        int[] mass = new int[5];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) (Math.random() * 50);
        }

        System.out.println("Show massive");
        for (int a : mass) {
            System.out.println(a);
        }
        System.out.println("\n");
//
//        BubbleSort bubbleSost = new BubbleSort();
//
        int[] sorted;


        Class clas = Main.class;

        Method[] method = clas.getDeclaredMethods();

        for (Method md : method) {
            if (md.isAnnotationPresent(Marker.class)) {
                System.out.println(md.getName());
                md.invoke(clas.newInstance(), mass.clone());
            }
        }
    }

    private static void mainMethod() throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        Class clas = Main.class;

        Method[] method = clas.getDeclaredMethods();
        System.out.println("length = " + method.length);
        for (Method md : method) {
            if (md.isAnnotationPresent(Marker.class)) {
                System.out.println(md.getName());
                md.invoke(clas.newInstance());
            }
        }
    }

    @Marker
    private void bubbleSortFloat(int[] mass) {
        int[] a = new BubbleSort().sortFloat(mass);
        for(int i : a) {
            System.out.println(i);
        }
    }

    @Marker
    private void bubbleSortSink(int[] mass) {
        int[] a = new BubbleSort().sortSink(mass);
        for(int i : a) {
            System.out.println(i);
        }
    }

    @Marker
    private int[] method2(int[] mass) {
        System.out.println(2);
        return null;
    }

    @Marker
    private int[] method3(int[] mass) {
        System.out.println(3);
        return null;
    }

//    @Target(value= ElementType.METHOD)
//    @Retention(value= RetentionPolicy.RUNTIME)
//    public @interface Marker {
//    }
}
