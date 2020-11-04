public class Navigation {

    boolean programIsRunning = true;

    FileHandling fileHandling = new FileHandling();
    FileProcessing fileProcessing = new FileProcessing();

    public void navigationMenu(Menu menu) {
       while (programIsRunning) {
            menu.printMenu();
            int choice = menu.setChoiceOfMenuAndValidateOutput();
            switch (choice) {

                case 1:
                    fileProcessing.readFile("Resources/Pizzas");
                    break;
                case 2:
                    fileHandling.addOrders();
                    break;
                case 3:
                    fileHandling.orderHistoryLogging();
                    break;
                case 4:
                    fileHandling.removeOrder();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("- indtast venligst et tal fra menuen! -");
                    break;
            }
        }
   }
}
