import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class MenuMethods {

    ArrayList<File> orders = new ArrayList<>();
    FileProcessing fileProcessing = new FileProcessing();

    public void showMenu(){
        fileProcessing.readFile("Resources/pizzaMenu");
    }

    public void addOrders(){

        System.out.println("\nBestillinger:");

        for(int i = 0; i < orders.size(); i++) {

            int orderNumber = i+1;

            if (orderNumber == 1) {
                System.out.println("Bestilling laves: " + orders.get(i));
            } else if(orderNumber> 1 ){
                System.out.println("Bestilling afventer: " + orders.get(i));
            }
        }
        System.out.print("Indtast pizzanavn(e): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File order = new File(String.format("Resources/pizzaOrders/%s.txt",fileName));
        File orderHistory = new File(String.format("Resources/orderHistory/%s.txt",fileName));


        fileProcessing.getPizzaNamesAndPrices(); //Indsætter navne og priser i en arrayliste
        int totalOfOrder = fileProcessing.calculateTotalOfOrder(fileName); //Anvender arraylisten og kalkulere totalet af pizza'erne bestilt
        fileProcessing.writeToFile(order.getPath(),totalOfOrder); //Skriver prisen til dokumentet
        fileProcessing.writeToFile(orderHistory.getPath(),totalOfOrder); //Skriver det også på orderhistory

        try{
            order.createNewFile();
            orderHistory.createNewFile();
        } catch(IOException e) {
            e.printStackTrace();
        }

        orders.add(order);
        System.out.println("pizza'er: " + fileName + " tilføjet til bestillinger" + " Bestillingspris: " + totalOfOrder);

    }

    public void removeOrder(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < orders.size(); i++){
            int orderNumber = i;
            System.out.println("Bestilling " + orderNumber + ": " + orders.get(i));

        }
        System.out.println("Hviken bestilling vil du fjerne?");
        System.out.print("Bestilling nummer: ");

        int removeOrderNumber = scanner.nextInt();

        orders.get(removeOrderNumber).delete();
        orders.remove(removeOrderNumber);

    }

    /**
     * Måske skal vi rykke oprettelsen af en history file her?
     */
    public void orderHistoryLogging(){

    }
}
