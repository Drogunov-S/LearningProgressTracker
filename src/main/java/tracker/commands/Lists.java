package tracker.commands;

import tracker.users.User;
import tracker.databese.Database;
import tracker.enitity.Result;
import tracker.utils.view.View;

import java.util.List;
import java.util.stream.Collectors;

import static tracker.constants.Constants.COMMAND_BACK;

public class Lists extends Action {

    @Override
    public Result execute() {
        View view = getView();

        List<User> students = Database.getAllUsers();
        if (students.size() == 0) {
            view.printNoStudentsFound();
            return new Result(COMMAND_BACK);
        }

        List<Integer> idAllStudents = Database.getAllUsers()
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());

        view.printIdAllStudentsLine(idAllStudents);
        return new Result(COMMAND_BACK);
    }
}
