package mid.sem.q.Toys;

public class ToyFactory implements Producing{
    @Override
    public Toy getARobot(int id, String toyName) {
        return new Robot(id, toyName);
    }

    @Override
    public Toy getAPlushy(int id, String toyName) {
        return new Plushy(id, toyName);
    }

    @Override
    public Toy getACar(int id, String toyName) {
        return new Car(id, toyName);
    }

    public Toy generateToy(String toyType, int id, String toyName){
        switch (toyType) {
            case "Робот":
                return getARobot(id, toyName);
            case "Плюшевая игрушка":
                return getAPlushy(id, toyName);
            default:
                return getACar(id, toyName);
        }
    }
}
