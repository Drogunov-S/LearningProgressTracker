package tracker.constants;

public class Constants {
    public static final int MAX_BALLS_JAVA = 600;
    public static final int MAX_BALLS_DSA = 400;
    public static final int MAX_BALLS_DATABASES = 480;
    public static final int MAX_BALLS_SPRING = 550;
    public static final String MASSAGE_START = "Learning Progress Tracker";
    public static final String MASSAGE_EXIT = "Enter 'exit' to exit the program";
    public static final String MASSAGE_END = "Bye!";
    public static final String MASSAGE_NO_INPUT = "No input.";
    public static final String MASSAGE_UNKNOWN_COMMAND = "Error: unknown command!";
    public static final String MASSAGE_ADDED_STUDENT = "The student has been added";
    public static final String COMMAND_ADD_STUDENTS = "add students";
    public static final String COMMAND_BACK = "back";
    public static final String MASSAGE_BACK_OR_ADD_STUDENTS = "Enter student credentials or '" + COMMAND_BACK + "' to return";
    public static final String MASSAGE_ADDED_TOTAL_STUDENTS = "Total %d students have been added%n";

    public static final String ERROR_FIRST_NAME = "Incorrect first name";
    public static final String ERROR_LAST_NAME = "Incorrect last name";
    public static final String ERROR_EMAIL = "Incorrect email";
    public static final String ERROR_UNKNOWN_CREDENTIALS = "Incorrect credentials";
    public static final String EXIT = "exit";
    public static final String ERROR_EMAIL_BUSY = "This email is already taken.";
    public static final String ADD_POINTS_OR_BACK = "Enter an id and points or 'back' to return";
    public static final String ENTER_OR_BACK = "Enter an id and or 'back' to return";
    public static final String ERROR_STUDENT_NIT_FOUND_FOR_ID = "No student is found for id=%s.";
    public static final String COMPLETE_POINTS_UPDATED = "Points updated.";
    public static final String NO_STUDENTS_FOUND = "No students found";
    public static final String INCORRECT_POINT_FORMAT = "Incorrect points format.";

    public static final String MASSAGE_TYPE_THE_NAME_OF_COURSE_OR_BACK = "Type the name of a course to see details or '" + COMMAND_BACK + "' to quit";

    public static final String STATISTICS_POPULAR_COURSE =
            "Most popular: %s\n"
                    + "Least popular: %s\n"
                    + "Highest activity: %s\n"
                    + "Lowest activity: %s\n"
                    + "Easiest course: %s\n"
                    + "Hardest course: %s\n";

    public static final String ERROR_UNKNOWN_COURSE = "Unknown course";

    public static final String MASSAGE_TOTAL_NOTIFY = "Total %s students have been notified.%n";

    public static final String MASSAGE_SEND_MASSAGE_COMPLETE_COURSE =
            "To: %s%n"
                    + "Re: Your Learning Progress%n"
            + "Hello, %s! You have accomplished our %s course!";
}

