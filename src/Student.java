// Student class
public class Student extends Person {
    // Instance variables
    private int grade;

    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getter & Setter methods
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // ToString method
    @Override
    public String toString() {
        return super.toString() + " Grade: " + this.grade;
    }
}
