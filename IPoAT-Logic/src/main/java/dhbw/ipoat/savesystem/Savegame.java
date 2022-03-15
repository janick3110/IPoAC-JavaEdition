package dhbw.ipoat.savesystem;


import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.encrypt.Encryption;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.player.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Savegame {

    private static List<Player> allPlayers = new ArrayList<>();
    public final static boolean bypassEncryption = true;
    public static Boolean autosave = true;

    public static void save(Player player){
        System.out.println("Saving game...");
        JSONObject jsonObject = new JSONObject();
        savePlayer(player);
        savePlayer(player);
        //jsonObject.put("Player", "Janick");
        writeToFile(savePlayer(player));
    }

    private static JSONObject savePlayer(Player player){
        JSONObject j = new JSONObject();

        //Add Player
        j.put("Money", player.getMoney());
        j.put("Days", player.getDay());
        j.put("Data", player.getAmountDataTransmitted());

        //Add Habitats
        JSONArray a = new JSONArray();
        for (Habitat h: player.getHabitatDict().values()
             ) {
          JSONObject habitat = new JSONObject();
          habitat.put("ID", h.getNameOfHabitat());
          habitat.put("Type", h.getHabitatTypes());
          habitat.put("maxCapacity", h.getMaxCapacity());
          habitat.put("avaliableNests", h.getAvaliableNests());
          habitat.put("costForNewNest",h.getCostOfNewNest());
          habitat.put("dailyCost",h.getDailyCost());
          habitat.put("costForBuying",h.getCost());
          JSONArray animalArray = new JSONArray();
            for (Animal animal: h.getAnimals()
                 ) {
                JSONObject animalJSON = new JSONObject();

                animalJSON.put("Name", animal.getName());
                animalJSON.put("Type", animal.getTypeOfAnimal());
                animalJSON.put("Age", animal.getAge());
                animalJSON.put("MaxAge", animal.getMaxAge());
                animalJSON.put("Speed", animal.getSpeed());
                animalJSON.put("Energy", animal.getEnergy());
                animalJSON.put("Cost", animal.getCost());
                animalJSON.put("Home", animal.isHome());
                animalJSON.put("Delivering", animal.isDelivering());
                animalJSON.put("Gender", animal.isGender());

                animalArray.put(animalJSON);
            }
            habitat.put("Animals", animalArray);
            a.put(habitat);
        }

        j.put("Habitats",a);

        JSONArray serverfarm = new JSONArray();
        for (Computer pc: player.getComputerDict().values()
             ) {
            JSONObject computer = new JSONObject();
            computer.put("PCName",pc.getNameOfPc());
            computer.put("Puffer",pc.getPuffer());
            serverfarm.put(computer);
        }
        j.put("Computers", serverfarm);

        JSONArray people = new JSONArray();

        for (Employee employee:player.getEmployeeDict().values()
             ) {
            JSONObject employeePerson = new JSONObject();
            employeePerson.put("ID",employee.getEmployeeID());
            employeePerson.put("Name",employee.getName());
            people.put(employeePerson);
        }
        j.put("Employees",people);



        return j;
    }


    public static void writeToFile(JSONObject save) {
        try {
            FileWriter myWriter = new FileWriter("savegame.txt");

            String txt;
            if (bypassEncryption){
                txt = save.toString();
            } else {
                txt = Encryption.doEncryption(save.toString());
            }

            myWriter.write(txt);
            //myWriter.write(save.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
