package mid.sem.q.FileManager;

import mid.sem.q.SpinningWheel.SpinningWheel;
import mid.sem.q.Toys.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToyManager {
    public List<String> readToys(){
        List<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader("toys1.txt");
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            if (line != null)
                while (line != null){
                    lines.add(line);
                    line = reader.readLine();
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public void fillTheWheel(SpinningWheel sw, List<String> linedToys){
        List<Toy> toys = new ArrayList<>();
        ToyFactory factory = new ToyFactory();
        linedToys.forEach(line -> {
            String[] toy_parameters = line.split("::");
            try {
                Toy newToy = factory.generateToy(toy_parameters[0].trim(),
                        Integer.parseInt(toy_parameters[1]), toy_parameters[2].trim());
                toys.add(newToy);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        sw.setSectors(toys);
    }

}
