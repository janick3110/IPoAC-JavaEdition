package dhbw.ipoat.computer;

import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.player.Player;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputerTest {

    @Test
    void generateData() throws InterruptedException {
        //Arrange
        Player mockPlayer = new Player("");
        Computer pcToTest = new Computer(mockPlayer);


        //Act

        Thread.sleep(10000);
        pcToTest.generateData();

        //Assert
        assertEquals(pcToTest.getData(),1);
    }
}