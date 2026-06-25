package challenge25;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // two courses with a lecture count
        Course jac = new Course("jac", "Java Advanced Class", 100);
        Course pbc = new Course("pbc", "Python Basics Class", 50);

        // third course - no lecture count
        Course games = new Course("cgj", "Creating Games in Java");

        // 5000 random students
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jac, pbc))
                .limit(5000)
                .toList();

        // average percent complete for the Java Advanced Class, using reduce
        double total = students.stream()
                .map(s -> s.getPercentComplete("jac"))
                .reduce(0.0, Double::sum);
        double average = total / students.size();
        System.out.printf("Average %% complete (Java Advanced) = %.2f%n", average);

        // students who completed more than the average boosted by 1.25
        double threshold = average * 1.25;
        List<Student> aboveAverage = students.stream()
                .filter(s -> s.getPercentComplete("jac") > threshold)
                .collect(Collectors.toList());
        System.out.println("Students above threshold: " + aboveAverage.size());

        // 10 longest-enrolled students from that group who are still active
        List<Student> trialStudents = aboveAverage.stream()
                .filter(s -> s.getMonthsSinceActive() < 6)
                .sorted(Comparator.comparingInt(Student::getYearsSinceEnrolled).reversed())
                .limit(10)
                .collect(Collectors.toList());

        // offer the new course to these ten students
        trialStudents.forEach(s -> s.addCourse(games));

        System.out.println("\nTrial students for the new course:");
        trialStudents.forEach(s -> System.out.printf(
                "%s -> jac %.1f%%, courses now %d%n",
                s, s.getPercentComplete("jac"), s.getEngagementMap().size()));
    }
}
