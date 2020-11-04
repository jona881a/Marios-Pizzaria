import java.util.Scanner;
import java.util.ArrayList;

public class MenuMethods {

    ArrayList<String> orders = new ArrayList<>();
    FileProcessing fileProcessing = new FileProcessing();

    public void showMenu(){
        fileProcessing.readFile("Resources/pizzaMenu");
    }

    public void addOrders(){
        System.out.println("\nBestillinger:");

        for(int i = 0; i<orders.size(); i++) {

            int orderNumber = i+1;

            if (orderNumber == 1) {
                System.out.println("Bestilling laves: " + orders.get(i));
            } else if(orderNumber> 1 ){
                System.out.println("Bestilling afventer: " + orders.get(i));
            }
        }
        System.out.print("Indtast pizza nummer: ");
        Scanner scanner = new Scanner(System.in);
        String menuNumber = scanner.nextLine();
        orders.add(menuNumber);
        System.out.println("pizza nummer: " + menuNumber + " tilføjet til bestillinger");
    }

    public void removeOrder(){
        orders.remove(0);
    }

    /**
     * HER SKAL VI BRUGE FILEPROCESSING TIL AT SKRIVE TIL FILEN ORDERHISTORY FOR AT GEMME ALLE ORDRE OG DERES BELØB
     */
    public void orderHistoryLogging(){

    }
}
