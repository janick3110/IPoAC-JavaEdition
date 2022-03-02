package dhbw.ipoat.savesystem;

public class JsonConstants {

    public static final String SAVEGAMEFILE = "savegame.json";

    public static final String PLAYERS = "players";
    public static final String NAME = "name";
    public static final String MON = "money";
    public static final String INV = "inventory";
    public static final String HAB = "habitat";
    public static final String MED = "medium";
    public static final String TRA = "transport device";


    public static final String DEFAULTSAVEGAME = "{\n" +
            "  \"players\":\n" +
            "  {\n" +
            "    \"0\":\n" +
            "    {\n" +
            "      \"name\":\"P1\",\n" +
            "      \"currency\":0,\n" +
            "      \"inventory\":[\n" +
            "        \"troop\"\n" +
            "      ]\n" +
            "    }";
}
