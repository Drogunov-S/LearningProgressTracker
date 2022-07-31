package tracker.utils;

import tracker.databese.Database;
import tracker.users.User;

import java.util.List;
import java.util.Locale;

import static tracker.constants.Constants.*;

public class Validator {

    public boolean validate(String[] input) {
        if (input.length < 3) {
            System.out.println(ERROR_UNKNOWN_CREDENTIALS);
            return false;
        }
        String firstName = input[0];
        String lastName = input[1];
        String email = input[2];

        return firstName(firstName)
                && lastName(lastName)
                && email(email)
                && isEmailFree(email);
    }

    public boolean firstName(String s) {
        String regexFirstName2 = "^(([A-Za-z]{2,})|([A-Za-z]+[\\-'][A-Za-z]+))+$";
        if (s.length() < 2 || (!s.matches(regexFirstName2))) {
            System.out.println(ERROR_FIRST_NAME);
            return false;
        }
        return true;
    }

    private boolean lastName(String s) {
        String regexLastName = "^(([A-Za-z]{2,})|([A-Za-z]+[\\-'\\s][A-Za-z]+)[\\s-]*)+$";
        if (s.length() < 2 || (!s.matches(regexLastName))) {
            System.out.println(ERROR_LAST_NAME);
            return false;
        }
        return true;
    }

    private boolean email(String s) {
        String regexEmail = "[A-z\\.?0-9]+@+[A-z0-9]+\\.[A-z0-9]+";
        if (!s.matches(regexEmail)) {
            System.out.println(ERROR_EMAIL);
            return false;
        }
        return true;
    }

    public boolean isEmailFree(String email) {
        boolean result = Database.getAllUsers()
                .stream()
                .map(User::getEmail)
                .anyMatch(userEmail -> userEmail.equals(email));
        if (result) {
            System.out.println(ERROR_EMAIL_BUSY);
            return false;
        }
        return true;
    }

    public boolean isAddPointsValidate(String enter) {
        return enter.matches("[0-9A-z]+ +[0-9]+ +[0-9]+ +[0-9]+ ((!-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+");
    }

    public boolean isNumeric(String enter) {
        try {
            Integer.parseInt(enter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isCourse(String enter) {
        enter = enter.toLowerCase(Locale.ROOT);
        return List.of("java", "dsa", "databases", "spring").contains(enter);
    }
}
