
public class ArrayList implements List {

    private String[] values;
    private int numberOfValues;

    private int cursor;

    public ArrayList() {
        values = new String[10];
        numberOfValues = 0;
        cursor = 0;
    }

    public ArrayList(int initSize) {
        values = new String[initSize];
        numberOfValues = 0;
        cursor = 0;
    }

    public void append(String v) {
        ensureCapacity();
        values[numberOfValues] = v;
        numberOfValues++;
    }

    public void insert(String v, int index) {
        if (index < 0 || index > numberOfValues) {
            throw new RuntimeException();
        }
        ensureCapacity();
        for (int i = numberOfValues; i > index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = v;
        numberOfValues++;
    }

    public void prepend(String v) {
        insert(v, 0);
    }

    public void remove(int index) {
        if (index < 0 || index >= numberOfValues) {
            throw new RuntimeException();
        }
        for (int i = index; i < numberOfValues - 1; i++) {
            values[i] = values[i + 1];
        }
        numberOfValues--;
    }

    public String get(int index) {
        if (index < 0 || index >= numberOfValues) {
            throw new RuntimeException();
        }
        return values[index];
    }

    public int size() {
        return numberOfValues;
    }

    public boolean contains(String v) {
        for (int i = 0; i < numberOfValues; i++) {
            if (values[i].equals(v)) {
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity() {
        if (numberOfValues == values.length) {
            String[] help = new String[values.length * 2];
            for (int i = 0; i < numberOfValues; i++) {
                help[i] = values[i];
            }
            values = help;
        }
    }

    public void reset() {
        cursor = 0;
    }

    public boolean hasMore() {
        return cursor < numberOfValues;
    }

    public String next() {
        if (!hasMore()) {
            throw new RuntimeException();
        }
        return values[cursor++];
    }

    public void removeNext() {
        if (!hasMore()) {
            throw new RuntimeException();
        }
        remove(cursor);
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
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
