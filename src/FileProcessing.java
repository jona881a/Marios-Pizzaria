import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;


public class FileProcessing {

    public void readFile(String path) {

        try {
            File file = new File(path);
            Scanner readFileScanner = new Scanner(file);

            while(readFileScanner.hasNext()) {
                System.out.println(readFileScanner.nextLine());
            }

            readFileScanner.close();

        } catch(FileNotFoundException f) {
            System.err.println("FEJL! Filen findes ikke med den specificerede path");
            f.printStackTrace();
        }
    }

    public void writeToFile(String path, String placeOrder) {
        try{
            FileWriter writeFile = new FileWriter(path);
            writeFile.write(placeOrder);
            writeFile.close();

        } catch (IOException e) {
            System.err.println("FEJL! Filen findes ikke med den specificerede path");
            e.printStackTrace();
        }
    }
}
