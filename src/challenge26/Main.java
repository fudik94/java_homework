package challenge26;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {

        // three courses, lecture counts greater than 40
        Course jmc = new Course("jmc", "Java Masterclass", 100);
        Course pymc = new Course("pymc", "Python Masterclass", 70);
        Course games = new Course("jgame", "Creating Games in Java", 55);

        // 10,000 students enrolled in the past 4 years
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc, games))
                .limit(10000)
                .toList();

        // 1. how many students are enrolled in each course
        Map<String, Long> perCourse = students.stream()
                .flatMap(s -> s.getEngagementMap().keySet().stream())
                .collect(groupingBy(code -> code, counting()));
        System.out.println("Students enrolled per course:");
        perCourse.forEach((code, count) -> System.out.println("  " + code + ": " + count));

        // 2. how many students are taking 1, 2, or 3 courses
        Map<Integer, Long> byCourseCount = students.stream()
                .collect(groupingBy(s -> s.getEngagementMap().size(), counting()));
        System.out.println("\nStudents by number of courses:");
        byCourseCount.forEach((num, count) -> System.out.println("  " + num + " course(s): " + count));

        // 3. average percent complete across all courses
        double avgComplete = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(averagingDouble(CourseEngagement::getPercentComplete));
        System.out.printf("%nAverage %% complete (all courses): %.2f%n", avgComplete);

        // 4. for each course, activity counts by last activity year
        Map<String, Map<Integer, Long>> activityByYear = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(groupingBy(CourseEngagement::getCourseCode,
                        groupingBy(CourseEngagement::getLastActivityYear, counting())));
        System.out.println("\nActivity counts by year, per course:");
        activityByYear.forEach((code, years) -> {
            System.out.println("  " + code + ":");
            years.forEach((year, count) -> System.out.println("    " + year + ": " + count));
        });
    }
}
