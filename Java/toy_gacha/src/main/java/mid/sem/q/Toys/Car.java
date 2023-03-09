package mid.sem.q.Toys;

public class Car extends Toy{

    private static int totalQTY = 0;
    public Car(int id, String name) {
        super(name, id);
        this.totalQTY++;
    }

    public static int getTotalQTY() {
        return totalQTY;
    }
    public static void decreaseQTY() {
        --totalQTY;
    }


    @Override
    public String toString() { return String.format("Машинка:\n" +
            "id: %d\n" +
            "%s\n" +
            "Всего: %d", getId(), super.toString(), getTotalQTY()); }
}
