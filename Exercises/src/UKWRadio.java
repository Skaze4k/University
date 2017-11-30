public class UKWRadio {

    private double frequenz;
    private double station[];

    public UKWRadio(int n) {
        this.frequenz = 87.5;
        this.station = new double[n];
    }

    public double getAktuelleFrequenz() {
        return frequenz;
    }

    public void frequenzVerringern() {
        if(this.frequenz==87.5){

        }
        else {
            this.frequenz -= 0.5;
        }
    }

    public void frequenzErhoehen() {
        if(this.frequenz==108.0){

        }
        else {
            this.frequenz += 0.5;
        }
    }

    public void frequenzSpeichern(int taste) {
        station[taste] = getAktuelleFrequenz();
    }

    public double frequenzEinstellen(int taste) {
        this.frequenz = station[taste];
        return frequenz;
    }

}
