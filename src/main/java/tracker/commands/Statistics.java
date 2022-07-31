package tracker.commands;

import tracker.databese.Database;
import tracker.enitity.Result;
import tracker.utils.StatisticsCourse;
import tracker.utils.Validator;
import tracker.utils.view.View;

import java.util.Scanner;

import static tracker.constants.Constants.*;
import static tracker.utils.StatisticsCourse.*;

public class Statistics extends Action{
    @Override
    public Result execute() {
        View view = getView();
        Validator validator = getValidator();

        view.print(MASSAGE_TYPE_THE_NAME_OF_COURSE_OR_BACK);
        Scanner scanner = new Scanner(System.in);

        view.printStatisticCourse(STATISTICS_POPULAR_COURSE,
                StatisticsCourse.get(MOST_POPULAR),
                StatisticsCourse.get(LEAST_POPULAR),
                StatisticsCourse.get(HIGHEST_ACTIVITY),
                StatisticsCourse.get(LOWEST_ACTIVITY),
                StatisticsCourse.get(EASIEST_COURSE),
                StatisticsCourse.get(HARDEST_COURSE)
        );

        while (true) {
            String course = scanner.next();
            if (course.equalsIgnoreCase(COMMAND_BACK)) {
                return new Result(COMMAND_BACK);
            }
            if (!validator.isCourse(course)) {
                view.print(ERROR_UNKNOWN_COURSE);
                continue;
            }
            view.printStudentsStatisticsOnCourse(Database.getTopStudents(course), course);
        }
    }


   /* public static void main(String[] args) {
        Student student0 = new Student("Brandise Hardan address1@mail.com".split(" "));
        student0.setAllGradeForCourse("1 5 4 3 1".split(" "));
        Student student1 = new Student("Gwenette Anagnos address2@mail.com".split(" "));
        student1.setAllGradeForCourse("2 5 4 3 1".split(" "));
        Student student2 = new Student("Annecorinne Ause address3@mail.com".split(" "));
        student2.setAllGradeForCourse("3 5 4 3 1".split(" "));
        Student student3 = new Student("Ricki Trovillion address4@mail.com".split(" "));
        student3.setAllGradeForCourse("4 5 4 3 1".split(" "));

        Statistics statistics = new Statistics();
        statistics.execute();
    }*/
}
