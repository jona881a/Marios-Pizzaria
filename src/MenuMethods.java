import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path pizzaOrdersDir = Paths.get(String.format("Resources/pizzaOrders/%s.txt",fileName));
        Path orderHistoryDir = Paths.get(String.format("Resources/orderHistory/%s.txt",fileName));
        File order = new File(pizzaOrdersDir.toString());


        fileProcessing.getPizzaNamesAndPrices(); //Indsætter navne og priser i en arrayliste
        int totalOfOrder = fileProcessing.calculateTotalOfOrder(fileName); //Anvender arraylisten og kalkulere totalet af pizza'erne bestilt
        fileProcessing.writeToFile(pizzaOrdersDir.toString(),totalOfOrder); //Skriver prisen til dokumentet

        try{
            order.createNewFile();
            Files.copy(pizzaOrdersDir,orderHistoryDir);//@TODO Der er et problem hvis der existere den samme fil, så vil den ikke kopiere den
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
     * HER SKAL VI BRUGE FILEPROCESSING TIL AT SKRIVE TIL FILEN ORDERHISTORY FOR AT GEMME ALLE ORDRE OG DERES BELØB
     */
    public void orderHistoryLogging(){

    }
}
