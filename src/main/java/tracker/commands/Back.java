package tracker.commands;

import tracker.enitity.Result;

import static tracker.constants.Constants.COMMAND_BACK;
import static tracker.constants.Constants.MASSAGE_EXIT;

public class Back extends Action {
    @Override
    public Result execute() {
        System.out.println(MASSAGE_EXIT);
        return new Result(COMMAND_BACK);
    }
}
