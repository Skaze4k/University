import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UKWRadioGUI extends Frame {

    UKWRadioGUI() {
        super("UKWRadio");
        this.addWindowListener(new WindowCloseAction());
        UKWRadio radio = new UKWRadio(2);
        this.setLayout(new GridLayout(4, 1));
        Label anzeige = new Label("" + radio.getAktuelleFrequenz());
        Panel einstellenPanel = new Panel();
        Panel stationstaste1Panel = new Panel();
        Panel stationstaste2Panel = new Panel();
        this.add(anzeige);
        this.add(einstellenPanel);
        this.add(stationstaste1Panel);
        this.add(stationstaste2Panel);

        einstellenPanel.setLayout(new GridLayout(1, 2));
        Button verringern = new Button("Frequenz verringern");
        verringern.addActionListener(new VerringernAction(anzeige, radio));
        Button erhoehen = new Button("Frequenz erhöhen");
        erhoehen.addActionListener(new ErhoehenAction(anzeige, radio));
        einstellenPanel.add(verringern);
        einstellenPanel.add(erhoehen);

        stationstaste1Panel.setLayout(new GridLayout(1, 3));
        Label name1 = new Label("Stationstaste 1");
        Button speichern1 = new Button("Frequenz speichern");
        speichern1.addActionListener(new FrequenzSpeichernAction(anzeige,
                radio, 0));
        Button einstellen1 = new Button("Frequenz einstellen");
        einstellen1.addActionListener(new FrequenzEinstellenAction(anzeige,
                radio, 0));
        stationstaste1Panel.add(name1);
        stationstaste1Panel.add(speichern1);
        stationstaste1Panel.add(einstellen1);

        stationstaste2Panel.setLayout(new GridLayout(1, 3));
        Label name2 = new Label("Stationstaste 2");
        Button speichern2 = new Button("Frequenz speichern");
        speichern2.addActionListener(new FrequenzSpeichernAction(anzeige,
                radio, 1));
        Button einstellen2 = new Button("Frequenz einstellen");
        einstellen2.addActionListener(new FrequenzEinstellenAction(anzeige,
                radio, 1));
        stationstaste2Panel.add(name2);
        stationstaste2Panel.add(speichern2);
        stationstaste2Panel.add(einstellen2);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UKWRadioGUI();
    }
}

class VerringernAction implements ActionListener {

    Label anzeige;
    UKWRadio radio;

    VerringernAction(Label anzeige, UKWRadio radio) {
        this.anzeige = anzeige;
        this.radio = radio;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        this.radio.frequenzVerringern();
        this.anzeige.setText("" + this.radio.getAktuelleFrequenz());
    }

}

class ErhoehenAction implements ActionListener {

    Label anzeige;
    UKWRadio radio;

    ErhoehenAction(Label anzeige, UKWRadio radio) {
        this.anzeige = anzeige;
        this.radio = radio;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        this.radio.frequenzErhoehen();
        this.anzeige.setText("" + this.radio.getAktuelleFrequenz());
    }
}

class FrequenzSpeichernAction implements ActionListener {

    Label anzeige;
    UKWRadio radio;
    int taste;

    FrequenzSpeichernAction(Label anzeige, UKWRadio radio, int taste) {
        this.anzeige = anzeige;
        this.radio = radio;
        this.taste = taste;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        this.radio.frequenzSpeichern(this.taste);
        this.anzeige.setText("" + this.radio.getAktuelleFrequenz());
    }
}

class FrequenzEinstellenAction implements ActionListener {

    Label anzeige;
    UKWRadio radio;
    int taste;

    FrequenzEinstellenAction(Label anzeige, UKWRadio radio, int taste) {
        this.anzeige = anzeige;
        this.radio = radio;
        this.taste = taste;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        this.radio.frequenzEinstellen(this.taste);
        this.anzeige.setText("" + this.radio.getAktuelleFrequenz());
    }
}

class WindowCloseAction extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

}
