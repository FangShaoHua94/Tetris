package storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StorageManager {

    private static final String FILE_PATH = System.getProperty("user.dir")
            + System.getProperty("file.separator") + "tetris.txt";
    private File file;


    public StorageManager() {
        try {
            file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {

        }
    }

    public int load() {
        int highScore = 0;
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            if (line != null) {
                highScore = Integer.parseInt(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return highScore;
    }

    public void save(int highScore) {
        try (FileWriter fw = new FileWriter(file)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("" + highScore);
            bw.close();
        } catch (IOException ex) {

        }
    }

}
