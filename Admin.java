import java.util.Map;
import java.util.Scanner;

// Admin class extends the User class
class Admin extends User {

    // Constructor for Admin, initializes with username and password
    public Admin(String username, String password) {
        super(username, password);
    }

    // Method to create a new student account
    public static void createStudentAccount(Scanner scanner, Map<String, Student> studentAccounts) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();

        // Check if the student ID already exists
        if (studentAccounts.containsKey(studentID)) {
            System.out.println("Student ID already exists. Please choose a different ID.");
            return;
        }

        // Gather student information
        System.out.print("Enter student password: ");
        String studentPassword = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter place of birth: ");
        String placeOfBirth = scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        scanner.nextLine();  // Consume the newline character

        // Create a Student instance
        Student newStudent = new Student(studentID, studentPassword, studentName, dateOfBirth, placeOfBirth, major, grade);

        // Read existing student data
        Map<String, Student> existingStudents = FileUtils.readStudentData();

        // Add the new student to the existing data
        existingStudents.put(studentID, newStudent);

        // Write all student data back to the file
        FileUtils.writeStudentData(existingStudents);

        System.out.println("Student account created successfully!");
    }

    // Method to view student data
    public static void viewStudentData(Map<String, Student> studentInfo) {
        studentInfo.forEach((studentID, student) ->
                System.out.println("Student ID: " + studentID + ", Name: " + student.getStudentName()
                        + ", Major: " + student.getMajor() + ", Grade: " + student.getGrade()));
    }

    // Method to update student data
    public static void updateStudentData(Scanner scanner, Map<String, Student> studentAccounts) {
        System.out.print("Enter student ID to update: ");
        String studentIDToUpdate = scanner.nextLine();

        if (studentAccounts.containsKey(studentIDToUpdate)) {
            System.out.println("--- Update Student Data ---");
            System.out.println("Enter new data for the student with ID " + studentIDToUpdate + ":");

            // Get the existing student
            Student existingStudent = studentAccounts.get(studentIDToUpdate);

            // Gather updated information
            System.out.print("Enter new student password: ");
            String newStudentPassword = scanner.nextLine();
            System.out.print("Enter new student name: ");
            String newStudentName = scanner.nextLine();
            System.out.print("Enter new date of birth: ");
            String newDateOfBirth = scanner.nextLine();
            System.out.print("Enter new place of birth: ");
            String newPlaceOfBirth = scanner.nextLine();
            System.out.print("Enter new major: ");
            String newMajor = scanner.nextLine();
            System.out.print("Enter new grade: ");
            String newGrade = scanner.nextLine();

            // Update the existing student data
            existingStudent.setStudentPassword(newStudentPassword);
            existingStudent.setStudentName(newStudentName);
            existingStudent.setDateOfBirth(newDateOfBirth);
            existingStudent.setPlaceOfBirth(newPlaceOfBirth);
            existingStudent.setMajor(newMajor);
            existingStudent.setGrade(newGrade);

            // Update the map with the modified student data
            studentAccounts.put(studentIDToUpdate, existingStudent);

            // Write all student data back to the file
            FileUtils.writeStudentData(studentAccounts);

            System.out.println("Student account updated successfully!");
        } else {
            System.out.println("Student account with ID " + studentIDToUpdate + " not found.");
        }
    }

    // Method to delete a student account
    public static void deleteStudentAccount(Scanner scanner, Map<String, Student> studentAccounts) {
        System.out.print("Enter student ID to delete: ");
        String studentIDToDelete = scanner.nextLine();

        if (studentAccounts.containsKey(studentIDToDelete)) {
            // Remove the student account
            Student deletedStudent = studentAccounts.remove(studentIDToDelete);
            System.out.println("Student account deleted successfully: " + deletedStudent.getStudentName());
            // Write the updated student data back to the file
            FileUtils.writeStudentData(studentAccounts);
        } else {
            System.out.println("Student account with ID " + studentIDToDelete + " not found.");
        }
    }
}
