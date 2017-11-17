public class UKWRadio {

    private double frequenz;
    private int station;

    public UKWRadio() {
        frequenz = 87.5;
    }

    public double getAktuelleFrequenz() {
        return frequenz;
    }

    public void frequenzVerringern() {
        frequenz -= 0.5;
    }

    public void frequenzErhoehen() {
        frequenz += 0.5;
    }

    public void frequenzSpeichern(int taste) {

    }

    public void frequenzEinstellen(int taste) {

    }

}
