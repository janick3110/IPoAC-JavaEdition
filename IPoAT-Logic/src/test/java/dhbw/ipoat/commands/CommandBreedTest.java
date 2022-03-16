package dhbw.ipoat.commands;

import org.junit.jupiter.api.Test;

class CommandBreedTest {


    @Test
    void breedTest() {
        /*Player player = EasyMock.createMock(Player.class);
        Animal animal1 = EasyMock.createMock(Pigeon.class);
        Animal animal2 = EasyMock.createMock(Pigeon.class);

        EasyMock.expect(animal1.isGender()).andReturn(true);
        EasyMock.expect(animal2.isGender()).andReturn(false);

        EasyMock.expect(animal1.getName()).andReturn("father");
        EasyMock.expect(animal1.getName()).andReturn("mother");

        EasyMock.expect(player.getAnimalWithName("father")).andReturn(animal1);
        EasyMock.expect(player.getAnimalWithName("mother")).andReturn(animal2);

        EasyMock.expect(animal1.getBreedingCooldown()).andReturn(0);
        EasyMock.expect(animal2.getBreedingCooldown()).andReturn(0);

        EasyMock.expect(animal1.getMaxAge()).andReturn(42);
        EasyMock.expect(animal2.getMaxAge()).andReturn(42);

        EasyMock.expect(animal1.getTypeOfAnimal()).andReturn("Pigeon");

        animal1.setBreedingCooldown(EasyMock.anyInt());
        animal2.setBreedingCooldown(EasyMock.anyInt());

        EasyMock.expect(animal1.getHabitatType()).andReturn(HabitatTypes.BIRDHOUSE);
        EasyMock.expect(animal2.getHabitatType()).andReturn(HabitatTypes.BIRDHOUSE);

        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);

        EasyMock.expect(player.getAllAnimals()).andReturn(animals);

        EasyMock.replay(animal1);
        EasyMock.replay(animal2);
        EasyMock.replay(player);

        CommandTemplate.setPlayer(player);

        CommandTemplate command = new CommandBreed();

        //command.execute("father|mother");*/

    }
}