package mid.sem.q.FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToyManager {
    public List<String> readToys(){
        List<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader("toys.txt");
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            if (line != null)
                lines.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null)
                    lines.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
