package challenge19;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    private int studentId;
    private String name;
    private String course;
    private int year;

    public Student(int studentId, String name, String course, int year) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // natural order: by studentId
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentId, other.studentId);
    }

    // comparator by course
    public static Comparator<Student> byCourse() {
        return Comparator.comparing(Student::getCourse);
    }

    // comparator by year
    public static Comparator<Student> byYear() {
        return Comparator.comparingInt(Student::getYear);
    }

    public boolean matchFieldValue(String fieldName, String value) {
        return switch (fieldName.toUpperCase()) {
            case "NAME"      -> name.equalsIgnoreCase(value);
            case "COURSE"    -> course.equalsIgnoreCase(value);
            case "YEAR"      -> year == Integer.parseInt(value);
            case "STUDENTID" -> studentId == Integer.parseInt(value);
            default -> false;
        };
    }

    public int getStudentId()  { return studentId; }
    public String getName()    { return name; }
    public String getCourse()  { return course; }
    public int getYear()       { return year; }

    @Override
    public String toString() {
        return String.format("id=%-4d name=%-20s course=%-15s year=%d",
                studentId, name, course, year);
    }
}
