public class LinkedStack implements Stack {
    private LinkedElement top;

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false;
    }

    public void push(String value) {
        top = new LinkedElement(value, top);
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        String value = top.getValue();
        top = top.getNext();
        return value;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return top.getValue();
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
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
