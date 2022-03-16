package dhbw.ipoat.habitat;

import dhbw.ipoat.player.Player;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HabitatTest {

    @Test
    void increaseSizeOfHabitat() {
        //Arrange
        Player player = EasyMock.createMock(Player.class);
        BirdHouse house = new BirdHouse(player);
        int places = house.avaliableNests;

        //Act
        house.IncreaseSizeOfHabitat();

        //Assert
        assertEquals(house.avaliableNests,places + 1);

    }
}