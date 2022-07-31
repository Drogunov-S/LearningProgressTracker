package tracker;

import tracker.controllers.MainController;
import tracker.enitity.Result;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();
    }

    public Result run(String[] args) {
        if (args.length > 0) {
            return mainController.doAction(args);
        }
        return mainController.doAction();
    }
}
