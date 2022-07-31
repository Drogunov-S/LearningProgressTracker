package tracker.utils.view;

import tracker.users.Student;

import java.util.List;

public interface View {
    void printIdAllStudentsLine(List<Integer> idStudents);

    void printPointsUpdate();

    void printEnterIdAndPointOrBack();

    void printNoStudentsFound();

    void incorrectPointFormat();

    void printf(String errorStudentNitFoundForId, String stringID);

    void print(String massage);

    void printGrades(Student student);

    void printStudentsStatisticsOnCourse(List<Student> topStudents, String course);

    void printStatisticCourse(String statisticsPopularCourse, String s, String s1, String s2, String s3, String s4, String s5);
}
