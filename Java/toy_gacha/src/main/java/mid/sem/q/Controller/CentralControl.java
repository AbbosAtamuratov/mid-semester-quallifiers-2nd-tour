package mid.sem.q.Controller;

import mid.sem.q.FileManager.ToyManager;
import mid.sem.q.SpinningWheel.SpinningWheel;
import mid.sem.q.Toys.Toy;

import java.util.HashMap;

public class CentralControl {

    private ToyManager tm = new ToyManager();
    private SpinningWheel wheel = new SpinningWheel();

    public void run(){
        boolean isRunning = true;
        String userInput;
        Toy lostSpace = new Toy("Вы проиграли");
        wheel.getDp().greet();

        tm.fillTheWheel(wheel, tm.readToys());
        while (isRunning) {
            wheel.getDp().menu();
            userInput = wheel.getDp().input("Введите номер команды: ");
            int command = Integer.parseInt(userInput);
            switch (command){
                case 1:
                    Toy prize = wheel.getThePrize(wheel.spinIt());
                    if (prize != lostSpace) {
                        wheel.getDp().show("Поздравляем! Вы выиграли: ");
                        wheel.getDp().show(prize.toString());
                    } else {
                        wheel.getDp().show("Не повезло...");
                    }
                    break;
                case 2:
                    HashMap<String, Integer> totals = wheel.getQTYs(wheel.getSectors());
                    totals.forEach((k,v) -> wheel.getDp().show(String.format("%s%d", k,v)));
                    break;
                case 3:
                    isRunning = false;
                    wheel.getDp().sayBB();
                    break;
                default:
                    wheel.getDp().show("Команда не распознана. Попробуйте ещё раз...");
                    break;
            }
        }
    }
}
