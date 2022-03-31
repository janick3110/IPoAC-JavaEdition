package dhbw.ipoat.animals;

import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.animals.mammals.Horse;
import dhbw.ipoat.player.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void calculateSellValueOfPigeon() {
        Player player = Mockito.mock(Player.class);
        Animal animal = new Pigeon(player);

        int price = animal.calculateSellValue();

        assertEquals(animal.price, price);
    }

    @Test
    void killAnimal() {
        Player player = new Player("");
        Animal animal = new Horse(player);

        player.getInventory().getAnimals().add(animal);
        player.getInventory().getAnimalsByName().put(animal.name, animal);

        animal.killAnimal();

        assertEquals(player.getInventory().getAnimals().size(), 0);
        assertEquals(player.getInventory().getAnimalsByName().size(), 0);
    }
}