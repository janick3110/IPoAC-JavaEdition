package dhbw.ipoat.events;

import java.util.HashMap;
import java.util.Random;

public class EventMap {

    public HashMap<EventToken, EventTemplate> eventMap;


    private void initializeMap() {
        eventMap.put(EventToken.birdWasKilledByASpear, new EventBirdKilledBySpear());
        eventMap.put(EventToken.fireInAHabitat, new EventFireInHabitat());
    }


    public void doSomethingGoodOrBad(int selector) {
        switch (selector) {
            case 0: {
                executeEvent1();
                break;
            }
            case 1: {
                executeEvent2();
                break;
            }
            case 3: {
                executeEvent3();
                break;
            }
            default:
                break;
        }
    }

    private void executeEvent1() {
        Random r = new Random();
        int money = r.nextInt(100 - 50) + 50;
        System.out.println("Happy Birthday! Your family sent you " + money + "€");
        //player.moneyTransactions(money);
    }

    private void executeEvent2() {
        System.out.println("You had to go to the vet because on of your birds became sick. It cost you 50€");
        //player.moneyTransactions(-50);
    }

    private void executeEvent3() {

    }
}
