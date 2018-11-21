package counter;

public class Counter {

    public static int counter = 0;
    public int nonStaticCounter = 0;

    public Counter() {
        counter++;
        System.out.println("value of counter " + counter);
        nonStaticCounter++;
        System.out.println("value of nonStaticCounter " + nonStaticCounter);

    }
}
