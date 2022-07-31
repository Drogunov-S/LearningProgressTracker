package tracker.users;

import tracker.commands.Executable;
import tracker.databese.Database;
import tracker.enitity.Result;
import tracker.utils.DelimiterInputDataStudent;
import tracker.utils.Validator;

import java.util.Scanner;

import static tracker.constants.Constants.*;

public class FabricStudents implements Executable {
    private final Validator validator = new Validator();
    DelimiterInputDataStudent delimiter = new DelimiterInputDataStudent();

    @Override
    public Result execute() {
        System.out.println(MASSAGE_BACK_OR_ADD_STUDENTS);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                System.out.println(ERROR_UNKNOWN_CREDENTIALS);
                continue;
            }
            String[] input = delimiter.get(line);
            if (input == null) {
                System.out.println(ERROR_UNKNOWN_CREDENTIALS);
                continue;
            }
            if (input[0].equals(COMMAND_BACK)) {
                System.out.printf(MASSAGE_ADDED_TOTAL_STUDENTS, Database.size());
                return new Result(COMMAND_BACK);
            }
            if (validator.validate(input)) {
                new Student(input);
                System.out.println(MASSAGE_ADDED_STUDENT);
            }
        }
    }
}
