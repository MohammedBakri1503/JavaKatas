package katas.exercises;

public class DoNTimes {

    /**
     * Executes the given function n times.
     *
     * @param func the function to execute
     * @param n    the number of times to execute the function
     */
    public static void doNTimes(Runnable func, int n) {
        if (func == null || n <= 0) {
            return; // Do nothing if the function is null or n is not positive
        }

        for (int i = 0; i < n; i++) {
            func.run();
        }
    }

    public static void main(String[] args) {
        Runnable sayHello = () -> System.out.println("Hello!");
        System.out.println("Calling function 3 times:");
        doNTimes(sayHello, 3);

        Runnable printMessage = () -> System.out.println("Java is fun!");
        System.out.println("Calling another function 5 times:");
        doNTimes(printMessage, 5);
    }
}

