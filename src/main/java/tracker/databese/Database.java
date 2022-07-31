package tracker.databese;

import tracker.exception.StudentNotFoundForId;
import tracker.users.Student;
import tracker.users.User;

import java.util.*;
import java.util.stream.Collectors;

import static tracker.constants.Constants.ERROR_STUDENT_NIT_FOUND_FOR_ID;

public class Database {
    private static final List<User> allUsers = new ArrayList<>();

    public static List<User> getAllUsers() {
        return allUsers;
    }

    public static Student getStudent(String stringID) {
        int id = Integer.parseInt(stringID);
        return (Student) allUsers
                .stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElseThrow(() -> {
                    System.out.printf(ERROR_STUDENT_NIT_FOUND_FOR_ID, id);
                    throw new StudentNotFoundForId("Student not found.");
                });
    }

    public static void add(User user) {
        allUsers.add(user);
    }

    public static int size() {
        return allUsers.size();
    }

    public static SortedMap<String, Integer> getPointsCourses() {
        SortedMap<String, Integer> pointsCourses = new TreeMap<>();

        for (User user : allUsers) {
            Student student = (Student) user;
            student.getCourses().forEach(course -> {
                Integer integer = pointsCourses.putIfAbsent(course.getClass().getSimpleName(), course.getGrade());
                if (integer != null) {
                    Integer value = pointsCourses.get(course.getClass().getSimpleName());
                    pointsCourses.put(course.getClass().getSimpleName(), integer + value);
                }
            });
        }
        pointsCourses.entrySet().stream().sorted((entry1, entry2) -> entry1.getValue() - entry2.getValue()).findFirst();
        return pointsCourses;
    }

    public static SortedMap<String, Integer> getStudentsOnCourses() {
        SortedMap<String, Integer> popular = new TreeMap<>();
        getAllStudents().stream()
                .map(Student::getCourses)
                .forEach(courses -> courses
                        .stream()
                        .filter(course -> course.getGrade() > 0)
                        .forEach(course -> {
                            Integer integer = popular.putIfAbsent(course.getClass().getSimpleName(), 1);
                            if (integer != null) {
                                popular.put(course.getClass().getSimpleName(), integer + 1);
                            }
                        }));

        return popular;
    }

    public static List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (User user : allUsers) {
            allStudents.add((Student) user);
        }
        return allStudents;
    }

    public static SortedMap<String, Integer> solvedTasks() {
        Comparator<Map.Entry<String, Integer>> sortValue = (k1, k2) -> k1.getValue() - k2.getValue();
        SortedMap<String, Integer> allCourseActivity = new TreeMap<>();
        allCourseActivity.entrySet().stream().sorted(sortValue).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        getAllStudents()
                .stream()
                .map(Student::getCourses)
                .forEach(courses -> courses.forEach(course -> {
                    int countSolution = course.getCountSolution();
                    Integer currentCount = allCourseActivity.putIfAbsent(course.getClass().getSimpleName(), countSolution);
                    if (currentCount != null) {
                        allCourseActivity.put(course.getClass().getSimpleName(), currentCount + countSolution);
                    }
                }));

        return allCourseActivity;
    }

    public static List<Student> getTopStudents(String findCourse) {

        List<Student> allStudents = getAllStudents();


        Map<String, List<Student>> collect = new HashMap<>();
        for (Student student : allStudents) {
            collect.computeIfAbsent(student.getCourse(findCourse).getClass().getSimpleName().toLowerCase(), k -> new ArrayList<>()).add(student);
        }

        List<Student> students = collect.get(findCourse.toLowerCase(Locale.ROOT));
        if (students == null) {
            return null;
        }

        return students
                .stream()
                .sorted((s1, s2) -> {
                    int result = (s1.getCourse(findCourse).getGrade() - s2.getCourse(findCourse).getGrade()) * -1;
                    if (result == 0) {
                        return s1.getId() - s2.getId();
                    }
                    return result;
                })
                .filter(student -> student.getCourse(findCourse).getGrade() > 0)
                .collect(Collectors.toList());


//                .entrySet()
//                .stream()
//                .sorted((s1, s2) -> s1.getKey())

        /*Comparator<Student> comparator = (o1, o2) -> {
            o1.getCourse(findCourse).
        };



        List<Set<Course>> collect = getAllStudents().stream()
                .map(Student::getCourses)
                .filter(courses -> courses
                        .stream()
                        .anyMatch(course1 -> course1
                                .toString().equalsIgnoreCase(findCourse)))
                .collect(Collectors.toList());
*/
    }

    private static void print(List<Student> list, String course) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId() + " " + student.getCourse(course).getGrade());
        }
    }
}
