import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessingTest {

    //Arrange
    FileProcessing fileProcessing = new FileProcessing();
    File file = new File("Resources/pizzaOrders/Pepmeddress.txt");
    String filePath = file.getPath();


    @Test
    void readFile() {
        //Act
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Assert
        fileProcessing.readFile(filePath);
    }

    @Test
    void getContentOfFile() {
        fileProcessing.getContentOfFile(filePath);
    }

    @Test
    void writeToFile() {
        //Act
        fileProcessing.writeToFile(filePath,65);
        String amountOfOrder = fileProcessing.getContentOfFile(filePath);

        //Assert
        assertEquals(65,Integer.parseInt(amountOfOrder));
    }

    @Test
    void getPizzaNamesAndPrices() {
        fileProcessing.getPizzaNamesAndPrices();
    }

    @Test
    void calculateTotalOfOrder() {
        //Arrange
        fileProcessing.getPizzaNamesAndPrices();

        //Act
        int total = fileProcessing.calculateTotalOfOrder("Pepmeddress");

        //Assert
        assertEquals(65,total);
    }
}