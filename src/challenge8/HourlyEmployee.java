package challenge8;

public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, long employeeId, String hireDate, double hourlyPayRate) {
        super(name, birthDate, employeeId, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay() {
        return hourlyPayRate * 160; // standard 160h per month
    }

    public double getDoublePay() {
        return hourlyPayRate * 2; // double rate for overtime
    }

    public double getHourlyPayRate() { return hourlyPayRate; }
}
