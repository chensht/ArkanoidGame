/**
 * this class represents a counter.
 */
public class Counter {
    private int count;

    /**
     * a constructor of a counter by number.
     * @param number the number represent the count.
     */
    public Counter(int number) {
        this.count = number;
    }

    /**
     * this method increase the count by adding a number to the current one.
     * @param number the number added to the current one.
     */
    void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * this method decrease the count by subtract a number from the current one.
     * @param number the number subtracted from the current one.
     */
    void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * this method returns the current value of the counter.
     * @return the value of this counter.
     */
    int getValue() {
        return this.count;
    }
}