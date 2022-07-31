package tracker.utils.view;

import tracker.users.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static tracker.constants.Constants.*;

public class ConsoleView implements View {

    @Override
    public void printIdAllStudentsLine(List<Integer> idStudents) {
        System.out.println("Students:");
        idStudents.forEach(System.out::println);
    }

    @Override
    public void printPointsUpdate() {
        System.out.println(COMPLETE_POINTS_UPDATED);
    }

    @Override
    public void printEnterIdAndPointOrBack() {
        System.out.println(ADD_POINTS_OR_BACK);
    }

    @Override
    public void printNoStudentsFound() {
        System.out.println(NO_STUDENTS_FOUND);
    }

    @Override
    public void incorrectPointFormat() {
        System.out.println(INCORRECT_POINT_FORMAT);
    }

    @Override
    public void printf(String massage, String str) {
        System.out.printf(massage, str);
    }

    @Override
    public void print(String massage) {
        System.out.println(massage);
    }

    @Override
    public void printGrades(Student student) {
        StringBuilder out = new StringBuilder();
        out.append(student.getId())
                .append(" points: ");

        student.getCourses()
                .forEach(course -> out.append(course.toString())
                        .append("; "));

        out.delete(out.length() - 2, out.length());

        System.out.println(out);
    }

    @Override
    public void printStudentsStatisticsOnCourse(List<Student> topStudents, String course) {
        System.out.println(course);
        System.out.println("id\tpoints\tcompleted");
        if (topStudents == null) {
            return;
        }
        String statistic = topStudents.stream()
                .map(student -> String.format("%d\t%d\t\t%.1f%%"
                        , student.getId()
                        , student.getCourse(course).getGrade()
                        , completedCourse(course, student)))
                .collect(Collectors.joining("\n"));

        System.out.format("%s%n", statistic);
    }

    @Override
    public void printStatisticCourse(String statisticsPopularCourse, String s, String s1, String s2, String s3, String s4, String s5) {
        List<String> courses = new ArrayList<>(Arrays.asList(s, s1, s2, s3, s4, s5));
        courses
                .stream()
                .filter(course -> course.equalsIgnoreCase("dsa"))
                .forEach(String::toUpperCase);

        System.out.printf(statisticsPopularCourse
                , courses.get(0)
                , courses.get(1)
                , courses.get(2)
                , courses.get(3)
                , courses.get(4)
                , courses.get(5));
    }

    private double completedCourse(String course, Student student) {
        double grade = student.getCourse(course).getGrade();
        double comp = student.getCourse(course).getBallsComplete();
        return grade / comp * 100;
    }
/*

    public static void main(String[] args) {
        //test 2
        ConsoleView consoleView = new ConsoleView();

        Student student1 = new Student("Dolley Panther address1@mail.com".split(" "));
//        student1.setAllGradeForCourse("1 10 10 10 10".split(" "));
        student1.setAllGradeForCourse("1 8 7 7 5".split(" "));
        student1.setAllGradeForCourse("1 7 6 9 7".split(" "));
        student1.setAllGradeForCourse("1 6 5 5 0".split(" "));

        Student student2 = new Student("Dolley Panther address1@mail.com".split(" "));
//        student2.setAllGradeForCourse("1 10 10 10 10".split(" "));
        student2.setAllGradeForCourse("2 8 0 8 6".split(" "));
        student2.setAllGradeForCourse("2 7 0 0 0".split(" "));
        student2.setAllGradeForCourse("2 7 0 0 0".split(" "));

//        Student student3 = new Student("Dolley Panther address1@mail.com".split(" "));
//        student3.setAllGradeForCourse("1 10 10 10 10".split(" "));
//
//        Student student4 = new Student("Dolley Panther address1@mail.com".split(" "));
//        student4.setAllGradeForCourse("1 10 10 10 10".split(" "));

        List<Student> students = new ArrayList<>(List.of(student1, student2*/
/*, student3, student4*//*
));



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
        */
/*
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
*//*


    }
*/

}

