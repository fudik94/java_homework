package challenge8;

public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, long employeeId, String hireDate, double annualSalary) {
        super(name, birthDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = false;
    }

    public void retire() {
        isRetired = true;
        System.out.println(getName() + " has retired.");
    }

    @Override
    public double collectPay() {
        double monthly = annualSalary / 12;
        return isRetired ? monthly : monthly * 0.85; // retired = full pay
    }

    public double getAnnualSalary() { return annualSalary; }
    public boolean isRetired() { return isRetired; }
}
