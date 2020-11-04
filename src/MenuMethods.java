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
        System.out.print("Indtast pizza nummer: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        String pathToOrders = String.format("Resources/pizzaOrders/%s.txt",fileName);
        String pathToOrderHistory = String.format("Resources/orderHistory/%s.txt",fileName);
        File order = new File(pathToOrders);
        File orderHistory = new File(pathToOrderHistory);
        try{
            order.createNewFile();
            orderHistory.createNewFile();
        } catch(IOException f) {
            f.printStackTrace();
        }

        orders.add(order);
        System.out.println("pizza nummer: " + fileName + " tilføjet til bestillinger");
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
