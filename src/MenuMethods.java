import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class MenuMethods {

    int ordersPlaced = 0;
    ArrayList<File> orders = new ArrayList<>();
    ArrayList<File> orderHistory = new ArrayList<>();
    FileProcessing fileProcessing = new FileProcessing();

    /**
     * Metode til at vise menu
     */
    public void showMenu(){
        System.out.println("------------------------------------------------------------------------------------");
        fileProcessing.readFile("Resources/pizzaMenu");
        System.out.println("------------------------------------------------------------------------------------");
    }

    /**
     * Tilføjer en fil til pizzaOrders og orderHistory samt orders listen med ordrens pizzaer i filnavnet og prisen for ordren i filen
     */
    public void addOrders(){

        //hvis der findes nogle ordre efter vi har lukket programmet indlæser vi dem i listen fordi de ikke er "gennemførte"
        if(orders.size() == 0) {
            File orderDirectory = new File("Resources/pizzaOrders");
            if(orderDirectory != null) {
                orders.addAll(Arrays.asList(orderDirectory.listFiles()));
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nBestillinger:");
        int orderNumber = 0;

        for(int i = 0; i < orders.size(); i++) {

            orderNumber = i+1;

            if (orderNumber == 1) {
                System.out.println("Bestilling laves: " + orders.get(i));
            } else if(orderNumber> 1 ){
                System.out.println("Bestilling afventer: " + orders.get(i));
            }
        }

        System.out.print("\nTilføj ny bestilling? 'ja/nej' : ");
        String yesNo = scanner.nextLine();

        switch(yesNo) {
            case "ja":
            System.out.print("Indtast pizzanavn(e): ");
            String fileName = scanner.nextLine();
            File order = new File(String.format("Resources/pizzaOrders/%s%d.txt", fileName, orderNumber));
            File orderHistory = new File(String.format("Resources/orderHistory/%s%d.txt", fileName,orderNumber));


            fileProcessing.getPizzaNamesAndPrices(); //Indsætter navne og priser i en arrayliste
            int totalOfOrder = fileProcessing.calculateTotalOfOrder(fileName); //Anvender arraylisten og kalkulere totalet af pizza'erne bestilt
            fileProcessing.writeToFile(order.getPath(), totalOfOrder); //Skriver prisen til dokumentet
            fileProcessing.writeToFile(orderHistory.getPath(), totalOfOrder); //Skriver det også på orderhistory

            try {
                order.createNewFile();
                orderHistory.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            orders.add(order);
            ordersPlaced++;
            System.out.println("pizza'er: " + fileName + " tilføjet til bestillinger" + " Bestillingspris: " + totalOfOrder);
            break;

            case "nej":
                break;
        }
    }

    /**
     * Fjerne oprettede ordre både på listen og i mappen ved hjælp af ordrenummer
     */
    public void removeOrder(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < orders.size(); i++){
            int orderNumber = i;
            System.out.println("Bestilling " + orderNumber + ": " + orders.get(i));

        }
        System.out.println("Hviken bestilling skal fjernes?");
        System.out.print("Bestilling nummer: ");

        int removeOrderNumber = scanner.nextInt();

        orders.get(removeOrderNumber).delete();
        orders.remove(removeOrderNumber);

    }

    /**
     * Giver os ordrehistorikken med ordrerens indhold og totale beløb samtidigt med at den giver en total omsætning af alle ordre
     */
    public void getOrderHistory(){
        int totalRevenue = 0;
        orderHistory.clear(); //starter listen på en frisk så den ikke duplikere total omsætning

        //Her laver vi en liste med alle filer
        File directory = new File("Resources/orderHistory"); //path til directory

        if(directory.listFiles() != null) { //Check om listen er null
            orderHistory.addAll(Arrays.asList(directory.listFiles()));
        }
        if(orderHistory.size() == 0) { //check om listen er tom
            System.err.print("\nFEJL! Der er endnu ikke oprettet nogle ordre");
        } else {
            //Her displayer vi listen med dens ordre (Filnavn) og beløbet for ordren
            for (int i = 0; i < orderHistory.size(); i++) {
                File currentFile = orderHistory.get(i); //den fil vi kigger på på nuværende index af orderHistory
                String fileContent = fileProcessing.getContentOfFile(currentFile.getPath()); //læser det der findes inde i filen
                System.out.printf("\nBestilling: %s Beløb: %s kr.",
                        currentFile.getName().substring(0,currentFile.getName().indexOf('.')),fileContent); //Vi "shaver" .txt af for læsbarhed
                 //læser det der findes inde i den nuværende fil
                totalRevenue += Integer.parseInt(fileProcessing.getContentOfFile(currentFile.getPath())); //udregner total omsætning
            }
        }
        System.out.println("\nTotal omsætning: " + totalRevenue);
    }
}
