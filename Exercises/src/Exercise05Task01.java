public class Exercise05Task01 {
    public static void main(String[] args) {
        Zahl zahl1 = new Zahl();
        Zahl zahl2 = new Zahl();
        System.out.println("Zahl 1 =" + zahl1);
        System.out.println("Zahl 2 =" + zahl2);
        System.out.println();


        if (zahl1.compareTo(zahl2) > 0) {
            while (zahl1.compareTo(zahl2) > 0) {
                zahl1.dekr();
                zahl2.inkr();
            }
            System.out.println("Zahl 1 =" + zahl1);
            System.out.println("Zahl 2 =" + zahl2);
        }
        else if (zahl2.compareTo(zahl1) > 0) {
            while (zahl2.compareTo(zahl1) > 0) {
                zahl2.dekr();
                zahl1.inkr();
            }
            System.out.println("Zahl 1 =" + zahl1);
            System.out.println("Zahl 2 =" + zahl2);
        }
        else {
            System.out.println("Zahl 1 (" + zahl1 + ") und Zahl 2 (" + zahl2 + "sind gleich groß");
        }
    }
}
