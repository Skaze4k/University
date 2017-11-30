public class LinkedQueue implements Queue {
    private LinkedElement oldest;
    private LinkedElement newest;

    public LinkedQueue() {
        oldest = null;
        newest = null;
    }

    public boolean isEmpty() {
        return oldest == null;
    }

    public boolean isFull() {
        return false;
    }

    public void enque(String value) {
        if (oldest == null) {
            oldest = newest = new LinkedElement(value);
        } else {
            LinkedElement elem = new LinkedElement(value);
            newest.setNext(elem);
            newest = elem;
        }
    }

    public String deque() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        String value = oldest.getValue();
        oldest = oldest.getNext();
        return value;
    }

    public String front() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return oldest.getValue();
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
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
