package dhbw.ipoat.computer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputerTest {

    @Test
    void generateData() throws InterruptedException {
        //Arrange
        Computer pcToTest = new Computer();


        //Act

        Thread.sleep(5000);
        pcToTest.GenerateData();

        //Assert
        assertEquals(pcToTest.getPuffer(),1);
    }
}