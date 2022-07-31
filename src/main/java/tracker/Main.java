package tracker;

import tracker.enitity.Result;

import static tracker.constants.Constants.MASSAGE_START;

public class Main {
    public static void main(String[] args) {
        System.out.println(MASSAGE_START);

        Application application = new Application();
        Result result = application.run(args);

    }
}
