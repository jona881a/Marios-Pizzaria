import java.util.Scanner;

public class Menu {

    private String menuHeader; //The text above the menu
    private String userChoiceText; //the user gets prompted with a text telling what the user should do
    private String[] menuItems;

    public Menu(String menuHeader, String userChoiceText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.userChoiceText = userChoiceText;
        this.menuItems = menuItems;
    }

    public void printMenu() {
        System.out.println(menuHeader);

        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%f. %s\n",i, menuItems[i]);
        }
    }

    public int setChoiceOfMenuAndValidateOutput() {
        Scanner scanner = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1; //default value if the choice isn´t made correctly

        while(!validChoice) {
            System.out.println();
            System.out.print(userChoiceText);

            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                validChoice = true;
            } else {
                scanner.next();
            }
        }
        return choice;
    }
}
