public class Employee {

    public String name;

    private double salary;

    public void setName(String empName) {
        name = empName;
    }

    public void setSalary(double empSal) {
        salary = empSal;
    }

    public void printEmp() {
        System.out.println("name  : " + name);
        System.out.println("salary :" + salary);
    }

    int balance;

    void setbalance(int bal) {
        balance = bal;
    }

    int depo(int dep) {
        balance = balance + dep;
        return balance;
    }

    int withdraw(int withd) {
        balance = balance - withd;
        return balance;
    }

    public static void main(String args[]) {
        Employee empOne = new Employee();
        Employee empTwo = new Employee();
        empOne.setName("John");
        empTwo.setName("Max");
        empOne.setSalary(1000);
        empTwo.setSalary(2000);
        empOne.printEmp();
        empTwo.printEmp();

        // For the Bank system
        Employee cust1 = new Employee();
        cust1.setbalance(1000);
        System.out.println("john balance after withdrawal " + cust1.withdraw(300));
        System.out.println("john balance after depositing  " + cust1.depo(3000));
        Employee cust2 = new Employee();
        cust2.setbalance(5000);
        System.out.println("max balance after withdrawal  " + cust2.withdraw(500));
        System.out.print("max balance after depositing  " + cust2.depo(3000));
    }

}