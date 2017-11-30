
public class ArrayStack implements Stack {
    private String[] values;
    private int current;

    public ArrayStack() {
        values = new String[10];
        current = -1;
    }

    public boolean isEmpty() {
        return current == -1;
    }

    public boolean isFull() {
        return false;
    }

    public void push(String value) {
        ensureCapacity();
        values[++current] = value;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return values[this.current--];
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return values[current];
    }

    void ensureCapacity() {
        if (current == values.length - 1) {
            String[] help = new String[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                help[i] = values[i];
            }
            values = help;
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        String input = IO.readString("Name: ");
        while (!input.equals("quit")) {
            stack.push(input);
            input = IO.readString("Name: ");
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

}
