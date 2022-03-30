package dhbw.ipoat.events;

import java.util.HashMap;
import java.util.Random;

public class EventMap {

    private static final HashMap<EventToken, EventTemplate> eventMap = new HashMap<>();

    public EventMap() {
        initializeMap();
    }

    public static void initializeMap() {
        eventMap.put(EventToken.birdWasKilledByASpear, new EventBirdKilledBySpear());
        eventMap.put(EventToken.fireInAHabitat, new EventFireInHabitat());
    }


    public void execute() {
        Random random = new Random();
        int chanceForEvent = 100;
        int probability = random.nextInt(chanceForEvent);

        if (probability < EventToken.values().length) {
            eventMap.get(EventToken.values()[probability]).execute(null);
        }
    }
}
