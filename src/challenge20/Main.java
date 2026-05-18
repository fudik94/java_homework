package challenge20;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    // prints employees sorted by years worked using local + anonymous class
    static void printEmployeesByExperience(List<Employee> employees) {

        // local class — wraps Employee with computed fields
        class EmployeeInfo {
            Employee employee;
            String fullName;
            int yearsWorked;

            EmployeeInfo(Employee e) {
                this.employee  = e;
                this.fullName  = e.firstName() + " " + e.lastName();
                this.yearsWorked = LocalDate.now().getYear() - e.hireDate().getYear();
            }

            @Override
            public String toString() {
                return fullName + " has been an employee for " + yearsWorked + " years";
            }
        }

        // build info list
        List<EmployeeInfo> infoList = new ArrayList<>();
        for (Employee e : employees) infoList.add(new EmployeeInfo(e));

        // anonymous comparator — sort by years worked ascending
        infoList.sort(new Comparator<EmployeeInfo>() {
            @Override
            public int compare(EmployeeInfo a, EmployeeInfo b) {
                return Integer.compare(a.yearsWorked, b.yearsWorked);
            }
        });

        for (EmployeeInfo info : infoList) {
            System.out.println(info);
        }
    }

    public static void main(String[] args) {

        // --- Task 1: inner class ---
        Meal meal = new Meal("Classic Beef", 5.00);
        meal.addToppings("lettuce", "ketchup", "cheese", "bacon");
        System.out.println(meal);

        System.out.println();

        // --- Task 2: local + anonymous class ---
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pille",  "Jõgi",  LocalDate.of(2001, 3, 15)));
        employees.add(new Employee("Hanno",  "Kalda", LocalDate.of(2014, 6, 1)));
        employees.add(new Employee("Lembe",  "Laht",  LocalDate.of(2012, 9, 20)));
        employees.add(new Employee("Kaarel", "Mets",  LocalDate.of(2016, 1, 10)));
        employees.add(new Employee("Liisi",  "Rand",  LocalDate.of(2021, 4, 5)));
        employees.add(new Employee("Jenni",  "Järv",  LocalDate.of(2012, 11, 30)));

        printEmployeesByExperience(employees);
    }
}
