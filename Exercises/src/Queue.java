
public interface Queue {

    // tests if this queue is empty
    public boolean isEmpty();

    // tests if this queue is full
    public boolean isFull();

    // inserts the specified element into this queue
    public void enque(String value);

    // retrieves and removes the head of this queue
    public String deque();

    // retrieves, but does not remove, the head of this queue.
    public String front();
}
