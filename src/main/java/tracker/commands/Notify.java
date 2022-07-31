package tracker.commands;

import tracker.constants.Constants;
import tracker.databese.Database;
import tracker.enitity.Result;
import tracker.enitity.courses.Course;
import tracker.users.Student;
import tracker.utils.view.View;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static tracker.constants.Constants.COMMAND_BACK;
import static tracker.constants.Constants.MASSAGE_TOTAL_NOTIFY;

public class Notify extends Action {
    @Override
    public Result execute() {
        View view = getView();

        List<Student> allStudents = Database.getAllStudents();
        Map<Student, List<Course>> mapNeededSendMassage = getStudentForSendMassage(allStudents);
        if (mapNeededSendMassage.size() != 0) {

            String massage = mapNeededSendMassage.entrySet().stream()
                    .map(pair -> {
                        Student student = pair.getKey();
                        return pair.getValue()
                                .stream()
                                .map(course -> {
                                    course.setMassageCompleteSend(true);
                                    return String.format(Constants.MASSAGE_SEND_MASSAGE_COMPLETE_COURSE
                                            , student.getEmail()
                                            , student.getFullName()
                                            , course.getCourseName());
                                })
                                .collect(Collectors.joining("\n"));
                    }).collect(Collectors.joining());
            view.print(massage);
        }

        view.printf(MASSAGE_TOTAL_NOTIFY, String.valueOf(mapNeededSendMassage.size()));

        return new Result(COMMAND_BACK);
    }

    private Map<Student, List<Course>> getStudentForSendMassage(List<Student> allStudents) {
        return allStudents.stream()
                .filter(student -> student.getCourses()
                        .stream()
                        .filter(Course::isComplete)
                        .anyMatch(course -> !course.isMassageCompleteSend()))
                .collect(Collectors.toMap(student -> student, o -> o.getCourses()
                        .stream()
                        .filter(Course::isComplete)
                        .filter(course -> !course.isMassageCompleteSend()).collect(Collectors.toList())));
    }

/*
    public static void main(String[] args) {
        //test 2
//        ConsoleView consoleView = new ConsoleView();

        Student student1 = new Student("Dolley1 Panther address1@mail.com".split(" "));
        student1.setAllGradeForCourse("600 400 10 10".split(" "));

        Student student2 = new Student("Dolley2 Panther address1@mail.com".split(" "));
        student2.setAllGradeForCourse("10 10 700 10".split(" "));

        Student student3 = new Student("Dolley3 Panther address1@mail.com".split(" "));
        student3.setAllGradeForCourse("10 10 10 800".split(" "));

        Student student4 = new Student("Dolley4 Panther address1@mail.com".split(" "));
        student4.setAllGradeForCourse("10 10 10 10".split(" "));

        List<Student> students = new ArrayList<>(List.of(student1, student2, student3, student4
        ));

        Notify notify = new Notify();
        notify.execute();

        notify.execute();

*//*
        consoleView.printStudentsStatisticsOnCourse(Database.getTopStudents("Java"), "Java");
        System.out.printf("-".repeat(10));
        consoleView.printStudentsStatisticsOnCourse(Database.getTopStudents("DSA"), "DSA");
        System.out.printf("-".repeat(10));
        consoleView.printStudentsStatisticsOnCourse(Database.getTopStudents("Databases"), "Databases");
        System.out.printf("-".repeat(10));
        consoleView.printStudentsStatisticsOnCourse(Database.getTopStudents("Databases"), "Databases");
        System.out.printf("-".repeat(10));
        consoleView.printStudentsStatisticsOnCourse(Database.getTopStudents("Java"), "Java");
        System.out.printf("-".repeat(10));
        //test 1
ConsoleView consoleView = new ConsoleView();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dolley Panther address1@mail.com".split(" ")));
        students.add(new Student("Jane Spark jspark@yahoo.com".split(" ")));
        for (Student student : students) {
            student.setAllGradeForCourse("24 2 3 4".split(" "));
        }

        for (Student student : students) {
            System.out.printf(student.getId() + " id " + student.getCourses());
        }

        consoleView.printStudentsStatisticsOnCourse(students, "Java");
*//**//*

         *//*
    }*/
}
