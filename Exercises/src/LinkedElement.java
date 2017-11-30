public class LinkedElement {
    private String value;
    private LinkedElement next;

    public LinkedElement(String v) {
        value = v;
        next = null;
    }

    public LinkedElement(String v, LinkedElement n) {
        value = v;
        next = n;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String v) {
        value = v;
    }

    public LinkedElement getNext() {
        return next;
    }

    public void setNext(LinkedElement elem) {
        next = elem;
    }
}