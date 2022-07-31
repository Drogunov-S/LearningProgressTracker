package tracker.commands;

import tracker.databese.Database;
import tracker.enitity.Result;
import tracker.users.Student;
import tracker.utils.Validator;
import tracker.utils.view.View;

import java.util.Scanner;

import static tracker.constants.Constants.*;

public class Find extends Action {
    @Override
    public Result execute() {
        View view = getView();
        Validator validator = getValidator();
        view.print(ENTER_OR_BACK);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String stringID = scanner.next();
            if (stringID.equals(COMMAND_BACK)) {
                return new Result(COMMAND_BACK);
            }

            if (!validator.isNumeric(stringID)) {
                view.printf(ERROR_STUDENT_NIT_FOUND_FOR_ID, stringID);
                continue;
            }
            Student student = Database.getStudent(stringID);
            view.printGrades(student);
        }
    }
}
