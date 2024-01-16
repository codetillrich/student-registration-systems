# student-registration-systems


## Introduction
The Student Registration System is a console-based application designed to manage and interact with administrator and student accounts. The system facilitates actions such as creating, viewing, updating, and deleting student accounts, as well as providing a login mechanism for both administrators and students.
## Features
**1. Administrator**<br/>
- Admin Login
- Create Student Account
- View Student Account
- Update Student Account
- Delete Student Account
- Logout

**2. Student Actions**<br/>
  - Student Login
  - View Profile

## Object-Oriented Features

### Classes & Objects

We have a total of 5 classes:
- User Class: An abstract class representing a user with common attributes (username and password) and methods for login, access level identification, and string representation.
- Admin Class: A subclass of the User class representing administrators. It includes methods for managing student data, deleting student accounts, viewing student data, and checking admin status.
- Student Class: A subclass of the User class representing students. It includes attributes for student-specific information and methods for accessing and updating student data.
- FileUtils Class: A utility class providing methods for reading and writing administrator credentials and student data to files ("adminCredentials.txt" and "studentData.txt").
- ReadFile Class: A utility class with a method for reading and printing the contents of text files.


### Inheritance

Inheritance is employed to create a hierarchy of classes. We have 1 Super classes:
- **User** serves as **SuperClass**, while both **Admin** class and **Student** class are **sub-classes** .
In this case, we use inheritance for better code structure as admin and student are both User. It is also for code reusability such as the login method.


### Polymorphism

**Override**

In User class: @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }

In Student sub-class: @Override
    public String toString() {
        return "Student ID: " + studentID +
               ", Name: " + studentName +
               ", Date of Birth: " + dateOfBirth +
               ", Place of Birth: " + placeOfBirth +
               ", Major: " + major +
               ", Grade: " + grade;
    }

### Encapsulation

-**private**: Can only be accessible within the same class and not visible to subclasses or other classes. We use private on every field to ensure their the value can only be changed inside that class and cannot be modified by any external classes.

    private String studentID;
    private String studentPassword;
    private String studentName;
    private String dateOfBirth;
    private String placeOfBirth;
    private String major;
    private String grade;
    
We use private on these fields because these fields are the properties of the class, so we only want their value to be modified from within the class and not allowed any external inteference. 


-**protected**: Can be accessible within its own package and by subclasses, whether they are in the same package or not.</br>
We use it in method in **User.java**

    protected String username;
    protected String password;


### Abstraction

We have abstract class that is implemented in **User.java**

    abstract class User {
    
We use abstract class because we want to prevent the creation of the object for USer class as we do not need them. We use abstract class instead of interface because we need this class to include both concrete and abstract method.

### Exception Handling
Exception handling is incorporated to gracefully manage unexpected errors. This ensures the system can recover or gracefully terminate, we implement this to ensure the **file is not found** issue
- **file is not found**: We use the try and catch IOException to check whether the file that we need to open exist.<br/>

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
  


### File I/O

We have 2 files:
- **studentData.txt:** to store studentID, student password, name,  date of birth, place of birth, major, grade
- **adminCredentials.txt:** admin username , admin password

We use these 2 files separately because we want each file to store specific data, so that it won't create any issue when we read it.

### Lambda Expression
Lambda expressions enhance the system's flexibility and conciseness.

      public static void viewStudentData(Map<String, Student> studentInfo) {
        studentInfo.forEach((studentID, student) ->
                System.out.println("Student ID: " + studentID + ", Name: " + student.getStudentName()
                        + ", Major: " + student.getMajor() + ", Grade: " + student.getGrade()));
    }

### Static method
**'static'** method we use to access the class without creating an instance of the class. In the project. We use the static method is for an easy way to call out the function in other class and also call in within class.

    public static void viewStudentData(studentInfo)
    public static void updateStudentData(studentAccounts)
    public static void deleteStudentAccount(studentAccounts)
