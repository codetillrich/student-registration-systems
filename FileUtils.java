import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {

    public static void writeAdminCredentials(Map<String, String> adminCredentials) {
        writeCredentials(adminCredentials, "adminCredentials.txt", false);
    }

    public static void writeStudentData(Map<String, Student> students) {
        try (FileWriter writer = new FileWriter("studentData.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (Map.Entry<String, Student> entry : students.entrySet()) {
                Student student = entry.getValue();
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        student.getStudentID(),
                        student.getStudentPassword(),
                        student.getStudentName(),
                        student.getDateOfBirth(),
                        student.getPlaceOfBirth(),
                        student.getMajor(),
                        student.getGrade());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing student data to studentData.txt: " + e.getMessage());
        }
    }

    public static Map<String, String> readAdminCredentials() {
        return readCredentials("adminCredentials.txt");
    }

    public static Map<String, Student> readStudentData() {
        Map<String, Student> students = new HashMap<>();

        try (FileReader reader = new FileReader("studentData.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String studentID = parts[0];
                    String studentPassword = parts[1];
                    String studentName = parts[2];
                    String dateOfBirth = parts[3];
                    String placeOfBirth = parts[4];
                    String major = parts[5];
                    String grade = parts[6];

                    Student student = new Student(studentID, studentPassword, studentName, dateOfBirth, placeOfBirth, major, grade);
                    students.put(studentID, student);
                } else {
                    System.err.println("Invalid data format in studentData.txt: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading student data from studentData.txt: " + e.getMessage());
        }

        return students;
    }

    private static void writeCredentials(Map<String, String> credentials, String fileName, boolean append) {
        try (FileWriter writer = new FileWriter(fileName, append);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                String username = entry.getKey();
                String password = entry.getValue();
                String line = String.format("%s,%s", username, password);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing credentials to " + fileName + ": " + e.getMessage());
        }
    }

    private static Map<String, String> readCredentials(String fileName) {
        Map<String, String> credentials = new HashMap<>();

        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    credentials.put(username, password);
                } else {
                    System.err.println("Invalid data format in " + fileName + ": " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading credentials from " + fileName + ": " + e.getMessage());
        }

        return credentials;
    }
}
