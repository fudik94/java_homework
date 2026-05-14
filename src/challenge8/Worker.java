package challenge8;

public class Worker {

    private String name;
    private String birthDate; // format: YYYY-MM-DD
    private String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        int birthYear = Integer.parseInt(birthDate.substring(0, 4));
        return java.time.LocalDate.now().getYear() - birthYear;
    }

    public double collectPay() {
        return 0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
        System.out.println(name + " terminated on " + endDate);
    }

    public String getName() { return name; }
    public String getBirthDate() { return birthDate; }
    public String getEndDate() { return endDate; }

    @Override
    public String toString() {
        return "Worker: " + name + ", born: " + birthDate;
    }
}
