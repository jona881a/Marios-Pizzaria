import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;


public class FileProcessing {

    ArrayList<String> pizzasAndPrices = new ArrayList<>();

    /**
     * Læser filens linier og printer dem
     * @param path
     */
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

    /**
     * returnere en string med indholdet af den specificerede fil
     * @param path
     * @return
     */
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

    /**
     * Skriver prisen til den specificerede fil
     * @param path stien til filen der skal skrives til
     * @param totalOfOrder beløbet der skrives ind i filen
     */
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

    /**
     * Opretter et array der gemmer pizza'ernes navne og priser seperaret med komma
     */
    public void getPizzaNamesAndPrices() {

        try {
            File file = new File("Resources/pizzaMenu");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                //Vi udtrækker pizzaens navn og dens pris og ligger ind i en string med et komma som seperator
                pizzasAndPrices.add(currentLine.substring(0,currentLine.indexOf(":")) + "," + currentLine.substring(81,83));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("FEJL! Filen findes ikke med den specificerede path");
            e.printStackTrace();
        }
    }

    /**
     * Kalkulere den totale ordrepris ved at sammenligne alle pizzaer og priser på dem med de pizzaer der er findes på ordren
     * @param fileName navent på den fil vi skal kalkulere beløbet på som samtidigt er ordrens pizzaer
     * @return returnere det totale beløb af ordren
     */
    public int calculateTotalOfOrder(String fileName) {
        int total = 0;
        int currentOrderItem = 0; //Denne variabel bruges til at gå videre til næste pizza på ordren når der er afregnet på den nuværende pizza
        int i = 0;
        String[] orderItems = fileName.split(","); //splitter ordrene i hver sit pizzanavn

        while(currentOrderItem < orderItems.length) {

            String currentPizza = pizzasAndPrices.get(i); //vi tager den nuværende pizza i arraylisten med alle pizza'er
            String[] splitString = currentPizza.split(","); //Splitter ordren ind i hver sin pizza (Pepmeddress,Salatos kebabbos etc.)

            //hvis vi har et match med navnet på ordren så ligger vi til det totale af ordren til total
            if(orderItems[currentOrderItem].equals(splitString[0])) {
                total += Integer.parseInt(splitString[1]); //Vi udtrækker prisen af den fra pizzasAndPrices Array'et
                currentOrderItem++; //Gå til næste pizza på ordren, hvis der er flere
            }
            i++;
        }
        return total;
    }

}
