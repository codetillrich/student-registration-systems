// Define a class named Student that extends the User class
class Student extends User {

    // Declare private member variables for student-specific attributes
    private String studentID;
    private String studentPassword;
    private String studentName;
    private String dateOfBirth;
    private String placeOfBirth;
    private String major;
    private String grade;

    // Constructor to initialize student attributes and call the superclass constructor
    public Student(String studentID, String studentPassword, String studentName, String dateOfBirth, String placeOfBirth, String major, String grade) {
        super(studentID, studentPassword);
        this.studentID = studentID;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.major = major;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
               ", Name: " + studentName +
               ", Date of Birth: " + dateOfBirth +
               ", Place of Birth: " + placeOfBirth +
               ", Major: " + major +
               ", Grade: " + grade;
    }
    

    // Getter methods for accessing student attributes
    
    public String getStudentID() {
        return studentID;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getMajor() {
        return major;
    }

    public String getGrade() {
        return grade;
    }

    // Setter methods for modifying student attributes
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentPassword(String password){
        this.studentPassword = password;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
