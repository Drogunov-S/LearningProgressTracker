package tracker.commands;

import tracker.utils.Validator;
import tracker.utils.view.ConsoleView;
import tracker.utils.view.View;

public abstract class Action implements Executable {
    private final Validator validator = new Validator();
    private final View view = new ConsoleView();

    public View getView() {
        return view;
    }

    public Validator getValidator() {
        return validator;
    }
}
