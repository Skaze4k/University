
public interface Stack {

    // tests if this stack is empty
    public boolean isEmpty();

    // tests if this stack is full
    public boolean isFull();

    // pushes an item onto the top of this stack
    public void push(String value);

    // removes the element at the top of this stack and returns that element as
    // the value of this method
    public String pop();

    // looks at the element at the top of this stack without removing it from
    // the stack
    public String peek();

}
