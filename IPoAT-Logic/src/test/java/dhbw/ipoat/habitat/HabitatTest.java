package dhbw.ipoat.habitat;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.player.Player;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HabitatTest {

    @Test
    void increaseSizeOfHabitat() throws OperationNotAllowedException {
        //Arrange
        Player player = EasyMock.createMock(Player.class);
        BirdHouse house = new BirdHouse(player);
        int places = house.animalCapacity;

        //Act
        house.upgradeSize();

        //Assert
        assertEquals(house.animalCapacity,places + 1);

    }
}