
public class ArrayQueue implements Queue {
    private String[] values;
    private int numberOfElements;

    public ArrayQueue() {
        values = new String[10];
        numberOfElements = 0;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return false;
    }

    public void enque(String value) {
        ensureCapacity();
        values[numberOfElements] = value;
        numberOfElements++;
    }

    public String deque() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        String oldest = values[0];
        for (int i = 0; i < numberOfElements - 1; i++) {
            values[i] = values[i + 1];
        }
        numberOfElements--;
        return oldest;
    }

    public String front() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return values[0];
    }

    void ensureCapacity() {
        if (numberOfElements == values.length) {
            String[] help = new String[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                help[i] = values[i];
            }
            values = help;
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        String input = IO.readString("Name: ");
        while (!input.equals("quit")) {
            queue.enque(input);
            input = IO.readString("Name: ");
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.deque());
        }

    }

}
