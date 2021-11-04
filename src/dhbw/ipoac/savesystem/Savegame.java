package dhbw.ipoac.savesystem;

import dhbw.ipoac.player.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

//TODO implement
public class Savegame {

    private HashMap<String, Player> players = new HashMap<>();

    public Savegame() {
        players.put("player1", new Player());
    }

    public Savegame(JSONObject json) {
        try {
            JSONArray playersJson = json.getJSONArray(JsonConstants.PLAYERS);
            JSONObject player;
            for (int i = 0; i < playersJson.length(); i++) {
                player = playersJson.getJSONObject(i);
                players.put(player.getString(JsonConstants.NAME), new Player());
            }


        } catch (JSONException e) {
            System.out.println("JSON parse exception in Savegame constructor");
            e.printStackTrace();
            players.put("player1", new Player());
        }
    }


    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<String, Player> players) {
        this.players = players;
    }


    /*public String toJSON(int indent) {
        String ind = GeneralUtil.getIndent(indent);
        StringBuilder builder = new StringBuilder();
        builder.append(ind);
        builder.append("{\n");
        builder.append(ind);
        builder.append("  \"players\":\n");
        builder.append(ind);
        builder.append("  [\n");

        for (Player p: players.values()) {
            builder.append(p.toJSON(indent + 4));
            builder.append(",\n");
        }

        String tmp = builder.substring(0, builder.length() - 2);
        builder = new StringBuilder(tmp);
        builder.append("\n");
        builder.append(ind);
        builder.append("  ],\n");

        builder.append(sounds.toJSON(indent + 2));
        builder.append(ind);
        builder.append("}");

        return builder.toString();
    }*/
}
