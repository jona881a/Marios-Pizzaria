public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){
        //opretter menuen med ønsket indhold
        String menuHeader = "Mario's pizzaria";
        String userChoiceText = "Vælg en menu: ";
        String[] menuItems = {"Menukort","Bestillinger","Ordrehistorik","Fortrudt ordre","Afslut program"};

        Menu menu = new Menu(menuHeader,userChoiceText,menuItems);
        Navigation navigation = new Navigation();
        navigation.navigationMenu(menu);
    }
}
