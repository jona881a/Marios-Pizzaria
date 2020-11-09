import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuMethodsTest {

    MenuMethods menuMethods = new MenuMethods();

    @Test
    void showMenu() {
        menuMethods.showMenu();
    }

    @Test
    void addOrders() {
        menuMethods.addOrders();
    }

    @Test
    void removeOrder() {
        menuMethods.removeOrder();
    }

    @Test
    void getOrderHistory() {
    }
}