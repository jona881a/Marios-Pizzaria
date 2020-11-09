import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MenuMethodsTest {

    //Arrange
    MenuMethods menuMethods = new MenuMethods();
    File file = new File("Resources/pizzaOrders/Pepmeddress.txt");
    File historyFile = new File("Resources/orderHistory/Pepmeddress.txt");

    @Test
    void showMenu() {
        //Act
        menuMethods.showMenu();
    }

    @Test
    void addOrders() {
        //Arrange
        menuMethods.orders.add(file);

        //Assert
        assertEquals(file,menuMethods.orders.get(0));

    }

    @Test
    void removeOrder() {
        //Arrange
        menuMethods.orders.add(file);

        //Act
        menuMethods.orders.remove(file);

        //Assert
        assertEquals(0,menuMethods.orders.size());
    }

    @Test
    void getOrderHistory() {
        menuMethods.getOrderHistory();
    }
}