package dhbw.ipoat.animals;

import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.player.Player;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    float epsilon = 1E-6f;

    Player player;
    AnimalImplementation animalImp;
    Animal animal;

    @Before
    public void setUp() throws Exception {

        player = EasyMock.createMock(Player.class);
        animalImp = EasyMock.createMock(AnimalImplementation.class);

        player.unloadData(EasyMock.anyFloat());


        animal = new Pigeon(player, animalImp);


        EasyMock.replay();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void moveAnimalBirdPigeonTest50() {
        animal.setPercentageMoved(50.0f);

        animal.moveAnimal();

        assertEquals(animal.getPercentageMoved()-51.0 < epsilon , true);

        EasyMock.verify();
    }
}