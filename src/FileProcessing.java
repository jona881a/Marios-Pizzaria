import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;


public class FileProcessing {

    ArrayList<String> pizzasAndPrices = new ArrayList<>();

    public void readFile(String path) {

        try {
            File file = new File(path);
            Scanner readFileScanner = new Scanner(file);

            while(readFileScanner.hasNext()) {
                System.out.println(readFileScanner.nextLine());
            }

            readFileScanner.close();

        } catch(FileNotFoundException e) {
            System.err.println("FEJL! Filen findes ikke med den specificerede path");
            e.printStackTrace();
        }
    }

    public String getContentOfFile(String path) {
        StringBuilder sb = new StringBuilder();

        try {
            File file = new File(path);
            Scanner readFileScanner = new Scanner(file);

            while(readFileScanner.hasNext()) {
                sb.append(readFileScanner.nextLine());
            }

            readFileScanner.close();

        } catch(FileNotFoundException e) {
            System.err.println("FEJL! Filen findes ikke med den specificerede path");
            e.printStackTrace();
        }

        return sb.toString();
    }

    public void writeToFile(String path, int totalOfOrder) {
        try{
            FileWriter writeFile = new FileWriter(path);
            writeFile.write("" + totalOfOrder);
            writeFile.close();

        } catch (IOException e) {
            System.err.println("FEJL! Filen findes ikke med den specificerede path");
            e.printStackTrace();
        }
    }

    public void getPizzaNamesAndPrices() {

        try {
            File file = new File("Resources/pizzaMenu");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                pizzasAndPrices.add(currentLine.substring(0,currentLine.indexOf(":")) + "," + currentLine.substring(81,83));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("FEJL! Filen findes ikke med den specificerede path");
            e.printStackTrace();
        }
    }

    public int calculateTotalOfOrder(String fileName) {
        int total = 0;
        int currentOrderItem = 0;
        int i = 0;
        String[] orderItems = fileName.split(","); //splitter ordrene i hver sit pizzanavn

        while(currentOrderItem < orderItems.length) {

            String currentPizza = pizzasAndPrices.get(i);
            String[] splitString = currentPizza.split(",");

            if(orderItems[currentOrderItem].equals(splitString[0])) {
                total += Integer.parseInt(splitString[1]);
                currentOrderItem++;
            }
            i++;
        }
        return total;
    }
}
