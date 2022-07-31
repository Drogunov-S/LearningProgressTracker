package tracker.users;

import tracker.enitity.courses.*;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Student extends User {

    private final Set<Course> courses = new LinkedHashSet<>();

    public Student(String[] data) {
        super(data[0], data[1], data[2]);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Course getCourse(String findCourse) {
        for (Course course : courses) {
            if (findCourse.equalsIgnoreCase(course.getClass().getSimpleName())) {
                return course;
            }
        }
        return null;
        /*return courses.stream().filter(course1 -> course1.toString().equalsIgnoreCase(course))
                .findAny()
                .get();*/
    }


    public void setAllGradeForCourse(String[] grades) {
        int java, dsa, database, spring;
        java = Integer.parseInt(grades[0]);
        dsa = Integer.parseInt(grades[1]);
        database = Integer.parseInt(grades[2]);
        spring = Integer.parseInt(grades[3]);

        if (courses.size() > 0) {
            setNewGrade(java, dsa, database, spring);
        } else {
            courses.add(new Java(java));
            courses.add(new Dsa(dsa));
            courses.add(new Databases(database));
            courses.add(new Spring(spring));
        }
    }

    private void setNewGrade(int... grade) {
        Iterator<Course> iterator = courses.iterator();
        for (int i = 0; i < courses.size(); i++) {
            Course next = iterator.next();
            next.setGrade(next.getGrade() + grade[i]);
        }
    }

   /* public static void main(String[] args) {
        Student student = new Student(new String[]{"John", "Doe", "jdoe@yahoo.com"});
        student.setAllGradeForCourse(new String[]{"1", "1", "1","1"});
        AllUsers.add(student);
        Student student1 = AllUsers.getStudent(2);
        System.out.printf("%s %s",student1.getFirstName(), student1.getCourses());
    }*/
}
