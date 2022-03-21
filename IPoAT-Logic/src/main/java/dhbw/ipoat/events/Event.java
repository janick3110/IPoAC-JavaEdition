package dhbw.ipoat.events;

import dhbw.ipoat.player.Player;

import java.util.Random;

public class Event {

    private Player player;

    public Event(Player player) {
        this.player = player;
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
        player.moneyTransactions(money);
    }

    private void executeEvent2() {
        System.out.println("You had to go to the vet because on of your birds became sick. It cost you 50€");
        player.moneyTransactions(-50);
    }

    private void executeEvent3() {
        Random r = new Random();
        int damage = r.nextInt(3 - 1) + 1;
        System.out.println("You had a little fire in your habitat. " + damage + " nests were destroyed");
        player.moneyTransactions(-50);
    }
}
