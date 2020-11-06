public class Navigation {

    boolean programIsRunning = true;

    MenuMethods menuMethods = new MenuMethods();

    public void navigationMenu(Menu menu) {

       while (programIsRunning) {

            menu.printMenu();
            int choice = menu.setChoiceOfMenuAndValidateOutput();
            
            switch (choice) {

                case 1: //Vis menu kort
                    menuMethods.showMenu();
                    break;
                case 2: //tilføj bestillinger
                    menuMethods.addOrders();
                    break;
                case 3: //Se ordre historik
                    menuMethods.getOrderHistory();
                    break;
                case 4: //Fjern bestilling
                    menuMethods.removeOrder();
                    break;
                case 5: //Se statistik
                    menuMethods.getStatistics();
                    break;
                case 6: //Afslut program
                    System.exit(0);
                    break;
                default: //Fejl i indtastning
                    System.err.println("- indtast venligst et tal fra menuen! -");
                    break;
            }
        }
   }
}
