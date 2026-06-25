package challenge24;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course java = new Course("J1", "Java Masterclass", 400);
        Course python = new Course("P1", "Python Basics", 120);
        Course spring = new Course("S1", "Spring Framework", 250);

        // stream source using the static factory as supplier
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(java, python, spring))
                .limit(10000)
                .toList();

        // 1. male and female counts
        long males = students.stream().filter(s -> s.getGender().equals("M")).count();
        long females = students.stream().filter(s -> s.getGender().equals("F")).count();
        System.out.println("Male students: " + males);
        System.out.println("Female students: " + females);

        // 2. age ranges + summary statistics
        long under30 = students.stream().filter(s -> s.getAge() < 30).count();
        long between = students.stream().filter(s -> s.getAge() >= 30 && s.getAge() <= 40).count();
        long over40 = students.stream().filter(s -> s.getAge() > 40).count();
        System.out.println("\nUnder 30: " + under30);
        System.out.println("Between 30 and 40: " + between);
        System.out.println("Over 40: " + over40);

        IntSummaryStatistics ageStats = students.stream()
                .mapToInt(Student::getAge)
                .summaryStatistics();
        System.out.println("Age stats: " + ageStats);

        // 3. distinct country codes
        System.out.println("\nCountries:");
        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .forEach(System.out::println);

        // 4. any active student enrolled more than 7 years?
        boolean anyLongActive = students.stream()
                .anyMatch(s -> s.getYearsSinceEnrolled() > 7 && s.getMonthsSinceActive() < 6);
        System.out.println("\nActive students enrolled over 7 years? " + anyLongActive);

        // 5. print info for 5 students
        System.out.println("\nFive students:");
        students.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}
