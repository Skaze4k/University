public class LinkedList implements List {

    private LinkedElement first;
    private int numberOfElements;

    private LinkedElement cursor;
    private LinkedElement lastElem;

    public LinkedList() {
        first = null;
        numberOfElements = 0;
        cursor = null;
        lastElem = null;
    }

    public void append(String v) {
        insert(v, numberOfElements);
    }

    public void insert(String v, int index) {
        if (index < 0 || index > numberOfElements) {
            throw new RuntimeException();
        }
        if (index == 0) {
            prepend(v);
        } else {
            LinkedElement help = first;
            for (int i = 0; i < index - 1; i++) {
                help = help.getNext();
            }
            LinkedElement elem = new LinkedElement(v, help.getNext());
            help.setNext(elem);
            numberOfElements++;
        }
    }

    public void prepend(String v) {
        first = new LinkedElement(v, first);
        numberOfElements++;
    }

    public void remove(int index) {
        if (index < 0 || index >= numberOfElements) {
            throw new RuntimeException();
        }
        if (index == 0) {
            first = first.getNext();
        } else {
            LinkedElement help = first;
            for (int i = 0; i < index - 1; i++) {
                help = help.getNext();
            }
            help.setNext(help.getNext().getNext());
        }
        numberOfElements--;
    }

    public String get(int index) {
        if (index < 0 || index >= numberOfElements) {
            throw new RuntimeException();
        }
        LinkedElement help = first;
        for (int i = 0; i < index; i++) {
            help = help.getNext();
        }
        return help.getValue();
    }

    public int size() {
        return numberOfElements;
    }

    public boolean contains(String v) {
        LinkedElement help = first;
        while (help != null) {
            if (help.getValue().equals(v)) {
                return true;
            }
            help = help.getNext();
        }
        return false;
    }

    public void reset() {
        cursor = first;
        lastElem = null;
    }

    public boolean hasMore() {
        return cursor != null;
    }

    public String next() {
        if (!hasMore()) {
            throw new RuntimeException();
        }
        String res = cursor.getValue();
        lastElem = cursor;
        cursor = cursor.getNext();
        return res;
    }

    public void removeNext() {
        if (!hasMore()) {
            throw new RuntimeException();
        }
        if (lastElem != null) {
            lastElem.setNext(cursor.getNext());
            cursor = lastElem.getNext();
        } else {
            first = first.getNext();
            cursor = first;
        }
        numberOfElements--;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        String input = IO.readString("Name: ");
        while (!input.equals("quit")) {
            if (input.length() > 5) {
                list.append(input);
            } else {
                list.prepend(input);
            }
            input = IO.readString("Name: ");
        }

        list.print();

        list.reset();
        while (list.hasMore()) {
            String value = list.next();
            if (value.length() == 5 && list.hasMore()) {
                list.removeNext();
            }
        }

        list.print();
    }

    void print() {
        reset();
        while (hasMore()) {
            String value = next();
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
