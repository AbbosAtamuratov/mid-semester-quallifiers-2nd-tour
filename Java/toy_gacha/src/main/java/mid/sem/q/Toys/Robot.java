package mid.sem.q.Toys;

public class Robot extends Toy{

    private static int totalQTY = 0;
    public Robot(int id, String name) {
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
    public String toString() { return String.format("Робот:\n" +
            "id: %d\n" +
            "%s\n" +
            "Всего: %d", getId(), super.toString(), getTotalQTY()); }
}
