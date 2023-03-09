package mid.sem.q.Controller;

import mid.sem.q.FileManager.ToyManager;
import mid.sem.q.SpinningWheel.SpinningWheel;
import mid.sem.q.Toys.Toy;

import java.util.HashMap;
import java.util.List;

public class CentralControl {

    private ToyManager tm;
    private SpinningWheel wheel;

    public CentralControl(ToyManager tm, SpinningWheel wheel) {
        this.tm = tm;
        this.wheel = wheel;
    }

    public void run(){
        boolean isRunning = true;
        String userInput;
        Toy lostSpace = new Toy("Вы проиграли", 0);
        List<String> allToys = tm.readToys();
        wheel.fillTheWheel(allToys);
        wheel.getDp().greet();

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
                    wheel.getDp().show("\n");
                    HashMap<String, Integer> totals = wheel.getQTYs(wheel.getSectors());
                    totals.forEach((k,v) -> wheel.getDp().show(String.format("%s%d", k,v)));
                    wheel.getDp().show("\n");
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
