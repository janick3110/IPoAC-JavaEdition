package dhbw.IPoAC;

import dhbw.IPoAC.Player.Player;
import dhbw.IPoAC.commands.Commands;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Commands commands = new Commands();
        Player player = new Player();
        Scanner in = new Scanner(System.in);

        commands.setUpList();

        for (int i = 0; i < commands.getListOfCommands().size();i++){
            System.out.println(commands.getListOfCommands().get(i));
        }

        String s = "";

        while (in.hasNextLine()) {
            s = in.nextLine();

            if(s.toUpperCase().contains("BUY")){
                commands.buy(s.toUpperCase(), player);
            } else if(s.toUpperCase().contains("UPGRADE")){
                commands.increase(s.toUpperCase(), player);
            } else if (s.toUpperCase().contains("NEXT DAY")) {
                commands.nextDay(player);
            } else if (s.toUpperCase().contains("SEND")) {
                commands.send(player);
            }

            if (s.equalsIgnoreCase("EXIT")) {
                break;
            }
            // process the line
        }

    }
}
