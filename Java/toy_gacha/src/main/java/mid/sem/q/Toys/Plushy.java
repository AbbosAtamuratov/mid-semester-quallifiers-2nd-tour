package mid.sem.q.Toys;

public class Plushy extends Toy{

    private static int totalQTY = 0;
    public Plushy(int id, String name) {
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
    public String toString() { return String.format("Плюшевая игрушка:\n" +
            "id: %d\n" +
            "%s\n" +
            "Всего: %d", getId(), super.toString(), getTotalQTY()); }
}
