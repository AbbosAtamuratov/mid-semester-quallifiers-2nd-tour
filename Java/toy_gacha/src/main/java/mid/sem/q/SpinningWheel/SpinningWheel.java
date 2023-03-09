package mid.sem.q.SpinningWheel;
import mid.sem.q.Toys.*;
import mid.sem.q.View.Display;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SpinningWheel {
    private List<Toy> sectors = new ArrayList<>();
    private final Display dp = new Display();

    public List<Toy> getSectors() {
        return sectors;
    }

    public void setSectors(List<Toy> sectors) {
        this.sectors = sectors;
    }

    public Display getDp() {
        return dp;
    }

    public void addToy(Toy toy) {
        this.sectors.add(toy);
        dp.show(String.format("%s успешно добавлен(-а) на барабан", toy.getName()));
    }

    public void popToy(int index) {
        Toy loseSpot = new Toy("Вы проиграли", 0);
        this.sectors.remove(index);
        this.sectors.add(index, loseSpot);
    }

    public int spinIt() {
        for (int i = 0; i < new Random().nextInt(5); i++) {
            dp.show("Барабан крутится...");
        }
        return (int) (360 * Math.random());
    }

    public Toy getThePrize(int spinResult) {
        int winning_segment = (int) Math.floor(spinResult / (360.0 / getSectors().size()));
        Toy prize = getSectors().get(winning_segment);
        popToy(winning_segment);
        decreaseToys(prize);
        return prize;
    }

    private void decreaseToys(Toy prize) {
        boolean isCar = prize instanceof Car;
        boolean isRobot = prize instanceof Robot;
        boolean isPlushy = prize instanceof Plushy;
        if (isPlushy) {
            Plushy.decreaseQTY();
        } else if (isRobot) {
            Robot.decreaseQTY();
        } else if (isCar) {
            Car.decreaseQTY();
        } else {
        }
    }

    public HashMap<String, Integer> getQTYs(List<Toy> toys) {
        HashMap<String, Integer> QTYs = new HashMap<>();
        int robots = Robot.getTotalQTY();
        int cars = Car.getTotalQTY();
        int plushies = Plushy.getTotalQTY();
        QTYs.put("Всего роботов: ", robots);
        QTYs.put("Всего машинок: ", cars);
        QTYs.put("Всего плюшевых игрушек: ", plushies);
        return QTYs;
    }

    public void fillTheWheel(List<String> linedToys) {
        ToyFactory factory = new ToyFactory();
        linedToys.forEach(line -> {
            String[] toy_parameters = line.split("::");
            Toy newToy = factory.generateToy(toy_parameters[0].trim(),
                    Integer.parseInt(toy_parameters[1].trim()), toy_parameters[2].trim());
            sectors.add(newToy);
        });
    }
}