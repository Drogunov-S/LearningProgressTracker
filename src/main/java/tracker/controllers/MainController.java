package tracker.controllers;

import tracker.ConsoleCommand;
import tracker.commands.Executable;
import tracker.enitity.Result;
import tracker.exception.BackException;
import tracker.exception.CommandException;
import tracker.exception.InputException;
import tracker.exception.StudentNotFoundForId;

import static tracker.constants.Constants.*;


public class MainController {

    public Result doAction() {
        Result result;
        do {
            ConsoleCommand consoleCommand = new ConsoleCommand();
            String command = consoleCommand.getCommand();
            Executable executable = null;
            try {
                executable = Actions.find(command);
            } catch (InputException e) {
                System.out.println(MASSAGE_NO_INPUT);
                doAction();
            } catch (CommandException q) {
                System.out.println(MASSAGE_UNKNOWN_COMMAND);
                doAction();
            } catch (BackException | StudentNotFoundForId q) {
                doAction();
            }
            result = executable.execute();
        } while (result.getMassage().equals(COMMAND_BACK));
        return result;
    }

    public Result doAction(String[] action) {
        return null;
    }

}
