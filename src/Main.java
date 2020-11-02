public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    public void run(){
        String menuHeader = "Mario's pizzaria";
        String userChoiceText = "Vælg en menu: ";
        String[] menuItems = {"Menukort","Bestillinger","Ordrehistorik","Fjern bestilling2","Afslut program"};
        Menu menu = new Menu(menuHeader,userChoiceText,menuItems);
        Navigation navigation = new Navigation();
        navigation.navigationMenu(menu);
    }
}
