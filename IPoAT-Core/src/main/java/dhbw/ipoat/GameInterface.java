package dhbw.ipoat;

import org.json.JSONObject;

public interface GameInterface {

    int days();

    void running(boolean state);

    JSONObject getJSONFromGame();

    void nextDay();
}
