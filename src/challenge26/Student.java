package challenge26;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Student {

    private static final Random random = new Random();
    private static final String[] COUNTRY_CODES =
            {"US", "IN", "UA", "DE", "BR", "GB", "CA", "AU", "FR", "JP", "PL", "AZ"};

    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final boolean programmingExperience;
    private final Map<String, CourseEngagement> engagementMap = new LinkedHashMap<>();

    public Student(long studentId, String countryCode, int yearEnrolled, int ageEnrolled,
                   String gender, boolean programmingExperience, Course... courses) {
        this.studentId = studentId;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;
        for (Course course : courses) {
            addCourse(course);
        }
    }

    // usual getters
    public long getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getEngagementMap() {
        return engagementMap;
    }

    // calculated getters
    public int getYearsSinceEnrolled() {
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge() {
        return ageEnrolled + getYearsSinceEnrolled();
    }

    public int getMonthsSinceActive(String courseCode) {
        return engagementMap.get(courseCode).getMonthsSinceActive();
    }

    // least inactive months across all courses
    public int getMonthsSinceActive() {
        return engagementMap.values().stream()
                .mapToInt(CourseEngagement::getMonthsSinceActive)
                .min()
                .orElse(0);
    }

    public double getPercentComplete(String courseCode) {
        return engagementMap.get(courseCode).getPercentComplete();
    }

    // overloaded addCourse - defaults to today
    public void addCourse(Course course) {
        addCourse(course, LocalDate.now());
    }

    public void addCourse(Course course, LocalDate enrollDate) {
        engagementMap.put(course.getCourseCode(),
                new CourseEngagement(course, enrollDate, "Enrolled", 0, enrollDate));
    }

    public void watchLecture(String courseCode, int lectureNumber, int month, int year) {
        CourseEngagement engagement = engagementMap.get(courseCode);
        if (engagement != null) {
            engagement.watchLecture(lectureNumber, LocalDate.of(year, month, 1));
        }
    }

    // factory method with random data
    public static Student getRandomStudent(Course... courses) {
        LocalDate now = LocalDate.now();
        long id = 100_000 + random.nextInt(900_000);
        String country = COUNTRY_CODES[random.nextInt(COUNTRY_CODES.length)];
        int year = now.getYear() - random.nextInt(4); // enrolled in past 4 years
        int age = 18 + random.nextInt(28);            // 18-45 at enrollment
        String gender = random.nextBoolean() ? "M" : "F";
        boolean experience = random.nextBoolean();

        // pick a random number and random selection of courses (at least one)
        List<Course> shuffled = new ArrayList<>(List.of(courses));
        Collections.shuffle(shuffled);
        int courseCount = 1 + random.nextInt(courses.length);
        List<Course> selected = shuffled.subList(0, courseCount);

        Student student = new Student(id, country, year, age, gender, experience,
                selected.toArray(new Course[0]));

        // give each enrolled course some activity, minimum lecture 30
        for (Course course : selected) {
            int lecture = 30 + random.nextInt(course.getLectureCount() - 30 + 1);
            int activityYear = year + random.nextInt(now.getYear() - year + 1);
            int maxMonth = (activityYear == now.getYear()) ? now.getMonthValue() : 12;
            int activityMonth = 1 + random.nextInt(maxMonth);
            student.watchLecture(course.getCourseCode(), lecture, activityMonth, activityYear);
        }
        return student;
    }

    @Override
    public String toString() {
        return "Student %d [%s, age %d, %s, enrolled %d (%d yrs ago), experience=%b, courses=%d]"
                .formatted(studentId, countryCode, getAge(), gender, yearEnrolled,
                        getYearsSinceEnrolled(), programmingExperience, engagementMap.size());
    }
}
