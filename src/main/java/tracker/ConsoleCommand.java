package tracker;

import java.util.Scanner;

public class ConsoleCommand {

    public String getCommand() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        return command;
    }

}
