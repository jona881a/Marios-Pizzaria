public class Navigation {

    boolean programIsRunning = true;

    MenuMethods menuMethods = new MenuMethods();
    FileProcessing fileProcessing = new FileProcessing();

    public void navigationMenu(Menu menu) {
       while (programIsRunning) {
            menu.printMenu();
            int choice = menu.setChoiceOfMenuAndValidateOutput();
            switch (choice) {

                case 1:
                    menuMethods.showMenu();
                    break;
                case 2:
                    menuMethods.addOrders();
                    break;
                case 3:
                    menuMethods.orderHistoryLogging();
                    break;
                case 4:
                    menuMethods.removeOrder();
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
