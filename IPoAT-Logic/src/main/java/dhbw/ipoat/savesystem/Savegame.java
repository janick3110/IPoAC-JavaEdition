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
import java.util.Random;

public abstract class Savegame {

    private static final List<Player> allPlayers = new ArrayList<>();
    public final static boolean bypassEncryption = true;
    public static Boolean autosave = true;

    public static void save(Player player){
        System.out.println("Saving game...");
        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("Player", "Janick");

    }



    public static void writeToFile(JSONObject save) {
        try {
            FileWriter myWriter = new FileWriter("savegame.txt");

            String txt;
            if (bypassEncryption){
                txt = save.toString();
            } else {
                txt = Encryption.doEncryption(save.toString(),new Random().nextInt(2147483647));
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
