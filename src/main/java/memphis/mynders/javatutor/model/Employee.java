package memphis.mynders.javatutor.model;

public class Employee {
    private String firstName;
    private String lastName;
    private PhoneType phoneType;
    private String ssn;
    private double salary;

    public Employee(){

    }

    public Employee(String firstName, String lastName, PhoneType phoneType, String ssn, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneType = phoneType;
        this.ssn = ssn;
        this.salary = salary;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.getSalary(), getSalary()) != 0) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        if (getPhoneType() != employee.getPhoneType()) return false;
        return getSsn() != null ? getSsn().equals(employee.getSsn()) : employee.getSsn() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getPhoneType() != null ? getPhoneType().hashCode() : 0);
        result = 31 * result + (getSsn() != null ? getSsn().hashCode() : 0);
        temp = Double.doubleToLongBits(getSalary());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneType=" + phoneType +
                ", ssn='" + ssn + '\'' +
                ", salary=" + salary +
                '}';
    }
}
