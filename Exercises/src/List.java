
public interface List {

    // insert v as last element into the list
    public void append(String v);

    // insert v at the specified index into the list
    public void insert(String v, int index);

    // insert v at the first element into the list
    public void prepend(String v);

    // remove the element at the specified index from the list
    public void remove(int index);

    // get the String at the specified index
    public String get(int index);

    // get the current number of strings stored in the list
    public int size();

    // checks if v is element of the list
    public boolean contains(String v);

    // iteration methods (iteration through all elements)

    // resets the iterator
    public void reset();

    // checks if the list contains further elements
    public boolean hasMore();

    // returns the next element
    public String next();

    // removes the element after the current element
    public void removeNext();

}
