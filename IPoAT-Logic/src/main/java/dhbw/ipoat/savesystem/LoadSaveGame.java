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
            JSONObject object = arr.getJSONObject(i);
            Habitat habitat = new Habitat(object,player);
            JSONArray animals = object.getJSONArray("Animals");
            for (int j = 0; j < animals.length(); j++) {
                JSONObject animal = animals.getJSONObject(j);
                Animal animal1 = new Animal(animal,player);
                habitat.addAnimalToHabitat(getAnimalFromType(animal1.getTypeOfAnimal(), player,animal));
            }

            player.getHabitatDict().put(habitat.getNameOfHabitat(),
                    getHabitatFromType(habitat.getType(), player, animals.getJSONObject(i)));
        }
        return player;
    }

    private static Animal getAnimalFromType(String type, Player player, JSONObject object){
        if (type.equals("PIGEON")){
            return new Pigeon(object,player);
        } else return null;
    }

    private static Habitat getHabitatFromType(String type, Player player, JSONObject object){
        if (type.equals("BIRDHOUSE")){
            return new BirdHouse(object, player);
        } else return null;
    }

}
