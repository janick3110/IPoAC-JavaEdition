package dhbw.ipoac.savesystem;

import dhbw.ipoac.encrypt.Encryption;
import dhbw.ipoac.player.Player;
import org.json.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadSaveGame {


    private static String jsonString(){
        BufferedReader br = null;
        try {
            File file = new File("savegame.txt"); // java.io.File
            FileReader fr = new FileReader(file); // java.io.FileReader
            br = new BufferedReader(fr); // java.io.BufferedReader
            String line;
            while ((line = br.readLine()) != null) {
                return line;
            }
            String output = Encryption.doDecrypting(line);
        }
        catch(IOException e) { e.printStackTrace();}
        finally
        {
            try { if (br != null) br.close(); }
            catch(IOException e) { e.printStackTrace(); }
        }
        return null;
    }

    public static Player load(){
        Player player = new Player();
        String jsonString = jsonString() ; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        //String pageName = obj.getString("Money");
        //System.out.println(pageName);

        JSONArray arr = obj.getJSONArray("Habitats"); // notice that `"posts": [...]`
        for (int i = 0; i < arr.length(); i++)
        {
            System.out.println(arr.get(i).toString());
        }
        return player;
    }



}
