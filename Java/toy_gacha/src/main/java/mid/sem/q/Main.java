package mid.sem.q;

import mid.sem.q.Controller.CentralControl;
import mid.sem.q.FileManager.ToyManager;
import mid.sem.q.SpinningWheel.SpinningWheel;

public class Main {
    public static void main(String[] args) {
        ToyManager toyManager = new ToyManager();
        SpinningWheel sw = new SpinningWheel();
        CentralControl cc = new CentralControl(toyManager, sw);
        cc.run();

    }

}