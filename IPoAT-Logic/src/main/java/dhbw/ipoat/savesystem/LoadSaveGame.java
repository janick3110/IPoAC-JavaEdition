package dhbw.ipoat.savesystem;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.encrypt.Encryption;
import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.player.Player;
import org.json.*;

import java.io.*;
import java.util.Scanner;

public class LoadSaveGame {


    private static String jsonString(){

        Scanner sc = null;
        try {
            File file = new File("savegame.txt"); // java.io.File
            sc = new Scanner(file);     // java.util.Scanner
            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                // process the line
            }
            if (Savegame.bypassEncryption){
                return line;
            } else{
                String output = Encryption.doDecrypting(line);
                return output;
            }


        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (sc != null) sc.close();
        }
        return null;










    }


}
