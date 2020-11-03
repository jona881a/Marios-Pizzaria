import java.util.Scanner;
import java.util.ArrayList;
public class FileHandling {

    ArrayList<String> orders = new ArrayList<>();

    public void menuFile(){

    }

    public void orderAddFile(){
        System.out.println("\nBestillinger:" );
        for(int i = 0; i<orders.size(); i++) {
            int orderNumber = i+1;
            if (orderNumber == 1) {
                System.out.println("Bestilling laves: " + orders.get(i));
            }else if(orderNumber>1){
                System.out.println("Bestilling afventer: " + orders.get(i));
            }
        }
        System.out.print("Indtast pizza nummer: ");
        Scanner scanner = new Scanner(System.in);
        String menuNumber = scanner.nextLine();
        orders.add(menuNumber);
        System.out.println("pizza nummer: " + menuNumber + " tilføjet til bestillinger");
    }

    public void orderRemoveFile(){
        orders.remove(0);
    }


    public void historyFile(){

    }
}
