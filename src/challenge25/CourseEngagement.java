package challenge25;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CourseEngagement {

    private final Course course;
    private final LocalDate enrollmentDate;
    private final String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType,
                            int lastLecture, LocalDate lastActivityDate) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.engagementType = engagementType;
        this.lastLecture = lastLecture;
        this.lastActivityDate = lastActivityDate;
    }

    // usual getters
    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getEngagementType() {
        return engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

    public LocalDate getLastActivityDate() {
        return lastActivityDate;
    }

    // calculated getters
    public String getCourseCode() {
        return course.getCourseCode();
    }

    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }

    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }

    public String getLastActivityMonth() {
        return lastActivityDate.getMonth().toString();
    }

    // months passed since last activity
    public int getMonthsSinceActive() {
        return (int) ChronoUnit.MONTHS.between(lastActivityDate, LocalDate.now());
    }

    // percent of lectures watched
    public double getPercentComplete() {
        return (double) lastLecture / course.getLectureCount() * 100;
    }

    // called when student watches a lecture
    public void watchLecture(int lecture, LocalDate activityDate) {
        this.lastLecture = lecture;
        this.lastActivityDate = activityDate;
    }
}
