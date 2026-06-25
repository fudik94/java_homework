package challenge26;

// immutable course type
public class Course {

    private final String courseCode;
    private final String title;
    private final int lectureCount;

    public Course(String courseCode, String title, int lectureCount) {
        this.courseCode = courseCode;
        this.title = title;
        this.lectureCount = lectureCount;
    }

    // no lecture count given - use a default
    public Course(String courseCode, String title) {
        this(courseCode, title, 0);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getLectureCount() {
        return lectureCount;
    }
}
