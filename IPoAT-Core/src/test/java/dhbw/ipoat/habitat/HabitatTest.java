package dhbw.ipoat.habitat;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.player.Player;
import org.easymock.EasyMock;
import org.junit.Test;

import static org.junit.Assert.*;

public class HabitatTest {

    @Test
    public void addAnimal() {

        Pigeon pigeon = EasyMock.createNiceMock(Pigeon.class);
        EasyMock.expect(pigeon.getHabitatType()).andReturn(HabitatTypes.BIRDHOUSE);


        Player player = EasyMock.createMock(Player.class);

        EasyMock.replay();

        BirdHouse birdHouse = new BirdHouse(player);

        try {

            birdHouse.addAnimal(pigeon);

        }catch (OperationNotAllowedException e) {

            System.out.println(e.getMessage());
            assertTrue(false);
        }

        assertEquals(birdHouse.getAnimals().size(), 1);



    }
}