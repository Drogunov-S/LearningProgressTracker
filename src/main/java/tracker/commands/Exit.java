package tracker.commands;

import tracker.enitity.Result;

import static tracker.constants.Constants.EXIT;
import static tracker.constants.Constants.MASSAGE_END;

public class Exit extends Action {

    @Override
    public Result execute() {
        System.out.println(MASSAGE_END);
        return new Result(EXIT);
    }
}
