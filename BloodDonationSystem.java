import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    protected static ArrayList<Person> persons = new ArrayList<>();
    static void listPersons() {
        System.out.println("List of Persons:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    
    public String toString() {
        return "Name: " + name + " | Age: " + age;
    }
}

class Donor extends Person {
    private String bloodType;

    public Donor(String name, int age, String bloodType) {
        super(name, age);
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }
    static void addDonor(Scanner scanner) {
        System.out.println("Add a Donor");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Blood Type: ");
        String bloodType = scanner.nextLine();

        Donor donor = new Donor(name, age, bloodType);
        persons.add(donor);

        System.out.println("Donor added successfully!");
    }
    static void deleteDonor(Scanner scanner) {
        System.out.println("Delete a Donor");
        System.out.print("Enter the name of the donor to delete: ");
        String nameToDelete = scanner.nextLine();

        Iterator<Person> iterator = persons.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person instanceof Donor && person.getName().equalsIgnoreCase(nameToDelete)) {
                iterator.remove();
                found = true;
                System.out.println("Donor " + nameToDelete + " has been deleted.");
            }
        }

        if (!found) {
            System.out.println("Donor not found or not deleted.");
        }
    }
    static void searchDonor(Scanner scanner) {
        System.out.print("Enter the desired blood type: ");
        String searchBloodType = scanner.nextLine();

        System.out.println("Available Donors with Blood Type " + searchBloodType + ":");
        boolean found = false;
        for (Person person : persons) {
            if (person instanceof Donor && ((Donor) person).getBloodType().equalsIgnoreCase(searchBloodType)) {
                System.out.println(person);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching donors found.");
        }
    }
    public String toString() {
        return super.toString() + " | Blood Type: " + bloodType;
    }
}

class Seeker extends Person {
    private String requiredBloodType;

    public Seeker(String name, int age, String requiredBloodType) {
        super(name, age);
        this.requiredBloodType = requiredBloodType;
    }

    public String getRequiredBloodType() {
        return requiredBloodType;
    }
    static void addSeeker(Scanner scanner) {
        System.out.println("Add a Seeker");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Required Blood Type: ");
        String requiredBloodType = scanner.nextLine();

        Seeker seeker = new Seeker(name, age, requiredBloodType);
        persons.add(seeker);

        System.out.println("Seeker added successfully!");
    }

    
    public String toString() {
        return super.toString() + " | Required Blood Type: " + requiredBloodType;
    }
}

public class BloodDonationSystem {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Blood Donation System");
            System.out.println("1. Add Donor");
            System.out.println("2. Search for Donor");
            System.out.println("3. Add Seeker");
            System.out.println("4. Delete Donor");
            System.out.println("5. List Persons");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Donor.addDonor(scanner);
                    break;
                case 2:
                    Donor.searchDonor(scanner);
                    break;
                case 3:
                    Seeker.addSeeker(scanner);
                    break;
                    

                case 4:
                    Donor.deleteDonor(scanner);
                    break;
                case 5:
                    Person.listPersons();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
   
}
