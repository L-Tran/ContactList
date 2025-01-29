// Teacher class
public class Teacher extends Person {
    // Instance variables
    private String subject;

    // Constructor
    public Teacher(String firstName, String lastName, String phoneNumber, String subject) {
        super(firstName, lastName, phoneNumber);
        this.subject = subject;
    }

    // Getter & Setter methods
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // ToString method
    @Override
    public String toString() {
        return super.toString() + " Subject: " + this.subject;
    }
}
