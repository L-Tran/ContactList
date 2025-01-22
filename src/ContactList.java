// Contact List by Logan Tran
import java.util.ArrayList;
import java.util.Scanner;

// ContactList class
public class ContactList {
    // Instance variables
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    // Run method
    public void run() {
        // Print instructions
        System.out.println("Welcome to your Contacts List");
        printInstructions();
        // Get option
        Scanner s = new Scanner(System.in);
        int option = - 1;
        // While not exiting
        while (option != 0) {
            option = s.nextInt();
            // Adding contact
            if (option == 1) {
                addContact();
            }
            // Printing contacts by first name
            else if (option == 2) {
                sort(0);
                printContacts();
            }
            // Printing contacts by last name
            else if (option == 3) {
                sort(1);
                printContacts();
            }
            // Printing contacts by number
            else if (option == 4) {
                sort(2);
                printContacts();
            }
            // Printing students only
            else if (option == 5) {
                listStudents();
            }
            // Searching by first name + printing person
            else if (option == 6) {
                // Ask for name
                System.out.println("Enter first name:");
                s.nextLine();
                String n = s.nextLine();
                // Verify name is in the list
                if (searchByFirstName(n) == null) {
                    System.out.println(n + " is not in the list.");
                }
                else {
                    System.out.println(searchByFirstName(n));
                }

            }
            // Searching by last name + printing person
            else if (option == 7) {
                // Ask for name
                System.out.println("Enter last name:");
                s.nextLine();
                String n = s.nextLine();
                // Verify name is in the list
                if (searchByLastName(n) == null) {
                    System.out.println(n + " is not in the list.");
                }
                else {
                    System.out.println(searchByLastName(n));
                }
            }
            // Searching by phone number + printing person
            else if (option == 8) {
                // Ask for number
                System.out.println("Enter phone number:");
                s.nextLine();
                String n = s.nextLine();
                // Verify number is in the list
                if (searchByPhoneNumber(n) == null) {
                    System.out.println(n + " is not in the list.");
                }
                else {
                    System.out.println(searchByPhoneNumber(n));
                }
            }
            // Reprint Instructions
            printInstructions();
        }
    }

    // Print instructions
    public void printInstructions() {
        System.out.println("Please pick from the following menu options\n" +
                "Menu:\n" +
                "1. Add Contact\n" +
                "2. List All Contacts By First Name\n" +
                "3. List All Contacts By Last Name\n" +
                "4. List All Contacts By Phone Number\n" +
                "5. List All Students\n" +
                "6. Search By First Name\n" +
                "7. Search By Last Name\n" +
                "8. Search by Phone Number\n" +
                "0. Exit");
    }

    // Getter method
    public ArrayList<Person> getContacts() {
        return this.contacts;
    }

    // Add method
    public void addContact() {
        // Ask for what type person
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add:\n" +
                "1. Student\n" +
                "2. Teacher");
        int object = s.nextInt();
        s.nextLine();
        // Get info to make person
        System.out.println("Please fill in the following information.\n" +
                "First Name:");
        String firstName = s.nextLine();
        System.out.println("Last Name:");
        String lastName = s.nextLine();
        System.out.println("Phone Number:");
        String number = s.nextLine();
        // Depending on what person they are create them
        if (object == 1) {
            System.out.println("Grade:");
            contacts.add(new Student(firstName, lastName, number, s.nextInt()));
        }
        else {
            System.out.println("Subject:");
            contacts.add(new Teacher(firstName, lastName, number, s.nextLine()));
        }
    }

    // Print contacts
    public void printContacts() {
        for (Person p: this.contacts) {
            System.out.println(p);
        }
    }

    // Sort method
    public void sort(int sortBy) {
        int n = contacts.size();
        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Sort first name
                if (sortBy == 0) {
                    // Compare location and swap
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        swap(j, j + 1);
                    }
                }
                // Sort last name
                if (sortBy == 1) {
                    // Compare location and swap
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        swap(j, j + 1);
                    }
                }
                // Sort number
                if (sortBy == 2) {
                    // Compare location and swap
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }

    // Swap method
    public void swap(int index1, int index2) {
        // Swap indexes with temp var
        Person temp = contacts.get(index1);
        contacts.set(index1, contacts.get(index2));
        contacts.set(index2, temp);
    }

    // Search by first name method
    public Person searchByFirstName(String firstName) {
        // Loop through until match
        for (Person p: contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        // return null if no match found
        return null;
    }

    // Search by last name method
    public Person searchByLastName(String lastName) {
        // Loop through until match
        for (Person p: contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        // return null if no match found
        return null;
    }

    // Search by number method
    public Person searchByPhoneNumber(String phoneNumber) {
        // Loop through until match
        for (Person p: contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        // return null if no match found
        return null;
    }

    // Print all students method
    public void listStudents() {
        // Loop through contacts and only print if a student
        for (Person p: contacts) {
            if(p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    // Main
    public static void main(String[] args) {
        // Run
        ContactList list = new ContactList();
        list.run();
    }
}
