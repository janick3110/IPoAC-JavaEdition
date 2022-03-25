package dhbw.ipoat.savesystem;


import dhbw.ipoat.GameInterface;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.encrypt.Encryption;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportDevice;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Savegame {

    private static final List<Player> allPlayers = new ArrayList<>();
    public final static boolean bypassEncryption = true;
    public static Boolean autosave = true;

    public static void save(Player player, GameInterface game){
        System.out.println("Saving game...");
        writeToFile(generateJSONFile(player, game));
    }



    public static void writeToFile(JSONObject save) {
        try {
            FileWriter myWriter = new FileWriter("savegame.txt");

            String txt;
            if (bypassEncryption){
                txt = save.toString(4);
            } else {
                txt = Encryption.doEncryption(save.toString(),new Random().nextInt());
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


    private static JSONObject generateJSONFile(Player player, GameInterface game){
        JSONObject savegame = new JSONObject();
        savegame.put("Savegamename", player.getPlayerName() + "-" + getDate());




        JSONObject inventory = new JSONObject();


        for (Employee employee:player.getInventory().getEmployees()){
            inventory.put("Employee", employee.generateJSONFromObject());
        }
        savegame.put("CounterForEmployees", Employee.counter);

        for (Habitat habitat: player.getInventory().getHabitats()){
            inventory.put("Habitats", habitat.generateJSONFromObject());
        }

        for (Medium medium: player.getInventory().getMediums()){
            inventory.put("Media", medium.generateJSONFromObject());
        }

        for (Computer computer: player.getInventory().getComputers()){
            inventory.put("Computers", computer.generateJSONFromObject());
        }

        for (TransportDevice device: player.getInventory().getTransportDevices()){
            inventory.put("Transportation", device.generateJSONFromObject());
        }

        for (Animal animal : player.getInventory().getAnimals()) {
            inventory.put("Animals", animal.generateJSONFromObject());
        }

        savegame.put("Inventory", inventory);
        savegame.put("Player", player.getJSONFromObject());
        savegame.put("Game", game.getJSONFromGame());

        return savegame;
    }

    private static String getDate() {
        return LocalDateTime.now().getYear() + "-" + LocalDateTime.now().getMonth().getValue() + "-" + LocalDateTime.now().getDayOfMonth();

    }
}
