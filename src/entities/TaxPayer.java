package entities;

public class TaxPayer {
    private double salaryIncome;
    private double serviceIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServiceIncome() {
        return serviceIncome;
    }

    public void setServiceIncome(double serviceIncome) {
        this.serviceIncome = serviceIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    //Imposto sob salario
    public double salaryTax() {
        double salaryMonth = salaryIncome / 12;
        double salaryTax = 0.00;
        if (salaryMonth < 3000.00) {
            salaryTax++;
        } else if (salaryMonth < 5000.00) {
            salaryTax = salaryIncome * 0.1;
        } else {
            salaryTax = salaryIncome * 0.2;
        }
        return salaryTax;
    }

    public double serviceTax() {
        return serviceIncome * 0.15;
    }

    public double capitalTax() {
        return capitalIncome * 0.2;
    }

    public double grossTax() {
        return salaryTax() + serviceTax() + capitalTax();
    }

    public double taxRebate() {
        double deductibleExpenses = healthSpending + educationSpending;
        double maximumDeductible = grossTax() * 0.3;

        return Math.min(maximumDeductible, deductibleExpenses);

    }

    public double netTax() {
        double taxGrossDue = 0.00;
        if (healthSpending + educationSpending > grossTax() * 0.3) {
            return taxGrossDue = grossTax() - grossTax() * 0.3;
        } else {
            return taxGrossDue = grossTax() - (healthSpending + educationSpending);
        }
    }
}
