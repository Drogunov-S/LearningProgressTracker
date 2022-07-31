package tracker.utils;

import tracker.databese.Database;

import java.util.*;
import java.util.stream.Collectors;

public enum StatisticsCourse {
    MOST_POPULAR, LEAST_POPULAR, HIGHEST_ACTIVITY, LOWEST_ACTIVITY, EASIEST_COURSE, HARDEST_COURSE;

    public static String get(StatisticsCourse statisticsCourse) {
        switch (statisticsCourse) {
            case MOST_POPULAR: {
                return popular(MOST_POPULAR);
            }
            case LEAST_POPULAR: {
                return popular(LEAST_POPULAR);
            }
            case HIGHEST_ACTIVITY: {
                return activity(HIGHEST_ACTIVITY);
            }
            case LOWEST_ACTIVITY: {
                return activity(LOWEST_ACTIVITY);
            }
            case EASIEST_COURSE: {
                return complexity(EASIEST_COURSE);
            }
            case HARDEST_COURSE: {
                return complexity(HARDEST_COURSE);
            }
        }
        return null;
    }

    private static String popular(StatisticsCourse command) {
        SortedMap<String, Integer> courses = Database.getStudentsOnCourses();

        switch (command) {
            case MOST_POPULAR: {
                List<String> collect = courses.entrySet()
                        .stream()
                        .filter(course -> course.getValue() > 0)
                        .limit(4)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
                return getStr(collect);
            }
            case LEAST_POPULAR: {
                return courses.entrySet()
                        .stream()
                        .min(Comparator.comparingInt(Map.Entry::getValue))
                        .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == 0)
                        .map(Map.Entry::getKey)
                        .orElse("n/a");
            }
            default: {
                return "n/a";
            }
        }
    }

    private static String activity(StatisticsCourse command) {
        SortedMap<String, Integer> allActivity = Database.solvedTasks();

        switch (command) {
            case HIGHEST_ACTIVITY: {
                List<String> collect = allActivity.entrySet()
                        .stream()
                        .filter(course -> course.getValue() > 0)
                        .limit(4)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
                return getStr(collect);
            }
            case LOWEST_ACTIVITY: {
                return allActivity.entrySet()
                        .stream()
                        .min(Comparator.comparingInt(Map.Entry::getValue))
                        .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == 0)
                        .map(Map.Entry::getKey)
                        .orElse("n/a");
            }
            default: {
                return "n/a";
            }
        }
    }

    private static String complexity(StatisticsCourse command) {
        SortedMap<String, Integer> result = new TreeMap<>();
        SortedMap<String, Integer> pointsCourses = Database.getPointsCourses();
        SortedMap<String, Integer> studentsOnCourses = Database.getStudentsOnCourses();


        for (var pair : pointsCourses.entrySet()) {
            String course = pair.getKey();
            Integer allPoints = pair.getValue();
            Integer studentsOnCourse = studentsOnCourses.get(course);
            if (studentsOnCourse == null) {
                continue;
            }
            result.put(course, allPoints / studentsOnCourse);
        }

        switch (command) {
            case EASIEST_COURSE: {
                return result.entrySet()
                        .stream()
                        .max(Comparator.comparingInt(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElse("n/a");
            }
            case HARDEST_COURSE: {
                return result.entrySet()
                        .stream()
                        .min(Comparator.comparingInt(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElse("n/a");
            }
            default: {
                return "n/a";
            }
        }
    }


    private static String getStr(List<String> courses) {
        if (courses.size() == 0) {
            return "n/a";
        }
        courses.sort(Comparator.reverseOrder());
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equalsIgnoreCase("dsa")) {
                courses.set(i, courses.get(i).toUpperCase(Locale.ROOT));
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            if (i != courses.size() - 1) {
                str.append(courses.get(i))
                        .append(", ");
            } else {
                str.append(courses.get(i));
            }
        }
        return str.toString();
    }

}
