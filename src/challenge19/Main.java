package challenge19;

import java.util.Comparator;
import java.util.Random;

public class Main {

    static String[] firstNames = {
        "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace",
        "Henry", "Ivy", "Jack", "Karen", "Liam", "Mia", "Noah", "Olivia",
        "Paul", "Quinn", "Rachel", "Sam", "Tina"
    };

    static String[] lastNames = {
        "Smith", "Jones", "Brown", "Davis", "Wilson",
        "Miller", "Moore", "Taylor", "Anderson", "Thomas"
    };

    static String[] courses = {"Java", "Python", "JavaScript", "C++", "Data Science"};

    public static void main(String[] args) {
        Random random = new Random(42); // fixed seed for reproducible output

        QueryList<ScoredStudent> students = new QueryList<>();

        for (int i = 0; i < 25; i++) {
            String name    = firstNames[random.nextInt(firstNames.length)] + " "
                           + lastNames[random.nextInt(lastNames.length)];
            String course  = courses[random.nextInt(courses.length)];
            int year       = 1 + random.nextInt(4);
            double percent = random.nextInt(101); // 0-100

            students.add(new ScoredStudent(1001 + i, name, course, year, percent));
        }

        System.out.println("--- All 25 students ---");
        for (var s : students) System.out.println(s);

        // query: students <= 50% done
        QueryList<ScoredStudent> result = students.getStudentsByValue("percentComplete", "50");
        System.out.println("\n--- Students <= 50% done (" + result.size() + " found) ---");

        // sort 1: natural order (by studentId — from Comparable)
        result.sort(Comparator.naturalOrder());
        System.out.println("\nSorted by studentId (natural order):");
        for (var s : result) System.out.println(s);

        // sort 2: by course, then by studentId
        result.sort(Student.byCourse().thenComparing(Comparator.naturalOrder()));
        System.out.println("\nSorted by course, then studentId:");
        for (var s : result) System.out.println(s);
    }
}
