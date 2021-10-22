package dhbw.IPoAC;

import dhbw.IPoAC.Player.Player;
import dhbw.IPoAC.commands.Commands;

import java.io.Console;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Commands commands = new Commands();
        Player player = new Player();
        Scanner in = new Scanner(System.in);

        commands.SetUpList();

        for (int i = 0; i < commands.getListOfCommands().size();i++){
            System.out.println(commands.getListOfCommands().get(i));
        }

        String s = "";

        while (in.hasNextLine()) {
            s = in.nextLine();

            if(s.toUpperCase().contains("BUY")){
                commands.Buy(s.toUpperCase(), player);
            }

            if (s.toUpperCase().equals("EXIT")){
                break;
            }
            // process the line
        }

    }
}
