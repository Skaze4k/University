public class Zahl {

    private int wert ;

    public Zahl() {
        wert = (new java.util.Random()).nextInt(1000);
    }

    public void inkr() {
        wert++;
    }

    public void dekr() {
        wert--;
    }

    public boolean equals (Zahl zahl) {
        return wert == zahl.wert;
    }

    public int compareTo(Zahl zahl) {
        return wert - zahl.wert;
    }

    public String toString() {
        return Integer.toString(wert) ;
    }

}