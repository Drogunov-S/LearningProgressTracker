package tracker.controllers;

import tracker.commands.*;
import tracker.exception.CommandException;
import tracker.exception.InputException;
import tracker.users.FabricStudents;

import static tracker.constants.Constants.MASSAGE_NO_INPUT;
import static tracker.constants.Constants.MASSAGE_UNKNOWN_COMMAND;

public enum Actions {

    EXIT(new Exit()),
    ADD_STUDENTS(new FabricStudents()),
    BACK(new Back()),
    LIST(new Lists()),
    ADD_POINTS(new AddPoints()),
    FIND(new Find()),
    STATISTICS(new Statistics()),
    NOTIFY(new Notify());


    private final Executable executable;

    Actions(Executable executable) {
        this.executable = executable;
    }

    public static Executable find(String actionName) {
        if (actionName.isBlank()) {
            throw new InputException(MASSAGE_NO_INPUT);
        }

        try {
            Actions value = Actions.valueOf(actionName.toUpperCase().replace(' ', '_'));
            return value.executable;
        } catch (IllegalArgumentException e) {
            throw new CommandException(MASSAGE_UNKNOWN_COMMAND);
        }
    }

}
