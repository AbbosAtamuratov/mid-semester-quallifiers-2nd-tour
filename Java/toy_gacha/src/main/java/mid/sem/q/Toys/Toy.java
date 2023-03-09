package mid.sem.q.Toys;

public class Toy {
    private int id;
    private String name;
    public Toy(String name, int id){
        this.name = name;
        setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Название: %s", getName());
    }
}
