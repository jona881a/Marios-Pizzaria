public class Navigation {

    boolean programIsRunning = true;

    FileHandling fileHandling = new FileHandling();

    public void navigationMenu(Menu menu) {
       while (programIsRunning) {
            menu.printMenu();
            int choice = menu.setChoiceOfMenuAndValidateOutput();
            switch (choice) {

                case 1:
                    fileHandling.menuFile();
                    break;
                case 2:
                    fileHandling.orderAddFile();
                    break;
                case 3:
                    fileHandling.historyFile();
                    break;
                case 4:
                    fileHandling.orderRemoveFile();
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
