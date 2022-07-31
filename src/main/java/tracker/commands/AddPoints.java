package tracker.commands;

import tracker.databese.Database;
import tracker.enitity.Result;
import tracker.utils.Validator;
import tracker.utils.view.View;

import java.util.Arrays;
import java.util.Scanner;

import static tracker.constants.Constants.COMMAND_BACK;
import static tracker.constants.Constants.ERROR_STUDENT_NIT_FOUND_FOR_ID;

public class AddPoints extends Action {

    @Override
    public Result execute() {
        View view = getView();
        Validator validator = getValidator();

        view.printEnterIdAndPointOrBack();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String enter = scanner.nextLine();
            if (enter.equals(COMMAND_BACK)) {
                return new Result(COMMAND_BACK);
            }

            if (validator.isAddPointsValidate(enter)) {
                String[] dataOfGrade = enter.split(" ");
                String stringID = dataOfGrade[0];
                if (!validator.isNumeric(stringID)) {
                    view.printf(ERROR_STUDENT_NIT_FOUND_FOR_ID, stringID);
                    continue;
                }
                String[] grades = Arrays.copyOfRange(dataOfGrade, 1, dataOfGrade.length);
                Database.getStudent(stringID).setAllGradeForCourse(grades);
                view.printPointsUpdate();
            } else {
                view.incorrectPointFormat();
            }
        }
    }
}