import java.util.Map;
import java.util.Scanner;

public class StudentRegistrationSystem {

    public static Object studentID;

    public static void main(String[] args) {
        // Creating a map to store admin accounts
        Map<String, String> adminAccounts = FileUtils.readAdminCredentials();
        // Creating a map to store student accounts
        Map<String, Student> studentAccounts = FileUtils.readStudentData();

        // Prompting the user to select admin or student
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Student Registration System ---");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Admin login
                System.out.println("--- Admin Login ---");
                System.out.print("Enter admin username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Enter admin password: ");
                String adminPassword = scanner.nextLine();

                if (adminAccounts.containsKey(adminUsername) && adminAccounts.get(adminUsername).equals(adminPassword)) {
                    System.out.println("Admin login successful!");

                    boolean adminRunning = true;
                    while (adminRunning) {
                        System.out.println("\n--- Admin Actions ---");
                        System.out.println("1. Create Student Account");
                        System.out.println("2. View Student Account");
                        System.out.println("3. Update Student Account");
                        System.out.println("4. Delete Student Account");
                        System.out.println("5. Logout");
                        System.out.print("Enter your choice: ");
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (adminChoice) {
                            case 1:
                                // Creating a new student account
                                Admin.createStudentAccount(scanner, studentAccounts);
                                break;
                            case 2:
                                Admin.viewStudentData(studentAccounts);
                                break;
                            case 3:
                                Admin.updateStudentData(scanner, studentAccounts);
                                break;
                            case 4:
                                Admin.deleteStudentAccount(scanner, studentAccounts);
                                break;
                            case 5:
                                adminRunning = false;
                                System.out.println("Admin logged out.");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid admin username or password.");
                }
                break;
            case 2:
                // Student login
                System.out.println("--- Student Login ---");
                System.out.print("Enter student ID: ");
                String studentLoginID = scanner.nextLine();
                System.out.print("Enter student password: ");
                String studentLoginPassword = scanner.nextLine();

                Student student = studentAccounts.get(studentLoginID);

                if (student != null && student.login(studentLoginID, studentLoginPassword)) {
                    // Set the studentID here
                    studentID = studentLoginID;

                    System.out.println("Student login successful!");

                    boolean studentRunning = true;
                    while (studentRunning) {
                        System.out.println("\n--- Student Actions ---");
                        System.out.println("1. View Profile");
                        System.out.println("2. Logout");
                        System.out.print("Enter your choice: ");
                        int studentChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (studentChoice) {
                            case 1:
                                // View student profile
                                System.out.println(studentAccounts.get(studentID));
                                break;
                            case 2:
                                studentRunning = false;
                                System.out.println("Student logged out.");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid student ID or password.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
