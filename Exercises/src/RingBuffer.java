
public class RingBuffer implements Queue {

    private String[] values;
    private int head;
    private int count;

    public RingBuffer(int maxValues) {
        values = new String[maxValues];
        head = 0;
        count = 0;
    }

    public boolean isFull() {
        return count == values.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enque(String x) {
        if (isFull()) {
            throw new RuntimeException();
        }
        values[(head + count) % values.length] = x;
        count++;
    }

    public String deque() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        String result = values[head];
        head = (head + 1) % values.length;
        count--;
        return result;
    }

    public String front() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return values[head];
    }

    public static void main(String[] args) {
        RingBuffer queue = new RingBuffer(2);
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
