import java.util.Scanner;
import java.util.ArrayList;
public class FileHandling {

    ArrayList<Integer> orders = new ArrayList<>();

    public void menuFile(){

    }
    public void orderAddFile(){

        System.out.println("\nBestillinger:");
        for(int i = 0; i<orders.size(); i++) {
            int orderNumber = i+1;
            System.out.println("Bestilling " + orderNumber + ": " + orders.get(i));
        }
        System.out.print("Indtast pizza nummer: ");
        Scanner scanner = new Scanner(System.in);
        int menuNumber = scanner.nextInt();
        orders.add(menuNumber);
        System.out.println("pizza nummer " + menuNumber + " tilføjet til bestillinger");
    }

    public void orderRemoveFile(){

    }


    public void historyFile(){

    }


}
