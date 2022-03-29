package dhbw.ipoat.habitat;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.player.Player;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HabitatTest {

    @Test
    public void addAnimal() {

        Pigeon pigeon = Mockito.mock(Pigeon.class);
        Mockito.when(pigeon.getHabitatType()).thenReturn(HabitatTypes.BIRDHOUSE);

        Player player = Mockito.mock(Player.class);

        BirdHouse birdHouse = new BirdHouse(player);

        try {

            birdHouse.addAnimal(pigeon);

        } catch (OperationNotAllowedException e) {

            System.out.println(e.getMessage());
            fail();
        }

        assertEquals(birdHouse.getAnimals().size(), 1);
        Mockito.verify(pigeon);

    }
}