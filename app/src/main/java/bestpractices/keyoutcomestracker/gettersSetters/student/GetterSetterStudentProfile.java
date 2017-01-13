package bestpractices.keyoutcomestracker.gettersSetters.student;



public class GetterSetterStudentProfile {
    
    private int idStudent = 0;
    private String studentFirstName = null;
    private String studentLastName = null;
    private String studentSchoolID = null;
    private String studentSemester = null;
    private String studentNumberOfClasses = null;
    private String studentSchoolName = null;
    private boolean studentActive;
    
    public GetterSetterStudentProfile() {
        
    }
    
    public GetterSetterStudentProfile(int idStudent, String studentFirstName, String studentLastName, String studentSchoolID, String studentSemester, String studentNumberOfClasses, String studentSchoolName) {
        this.idStudent = idStudent;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentSchoolID = studentSchoolID;
        this.studentSemester = studentSemester;
        this.studentNumberOfClasses = studentNumberOfClasses;
        this.studentSchoolName = studentSchoolName;
    }

    public GetterSetterStudentProfile(String studentFirstName, String studentLastName, String studentSchoolID, String studentSemester, String studentNumberOfClasses, String studentSchoolName) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentSchoolID = studentSchoolID;
        this.studentSemester = studentSemester;
        this.studentNumberOfClasses = studentNumberOfClasses;
        this.studentSchoolName = studentSchoolName;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentSchoolID() {
        return studentSchoolID;
    }

    public void setStudentSchoolID(String studentSchoolID) {
        this.studentSchoolID = studentSchoolID;
    }

    public String getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(String studentSemester) {
        this.studentSemester = studentSemester;
    }

    public String getStudentNumberOfClasses() {
        return studentNumberOfClasses;
    }

    public void setStudentNumberOfClasses(String studentNumberOfClasses) {
        this.studentNumberOfClasses = studentNumberOfClasses;
    }

    public String getStudentSchoolName() {
        return studentSchoolName;
    }

    public void setStudentSchoolName(String studentSchoolName) {
        this.studentSchoolName = studentSchoolName;
    }

    public boolean isStudentActive() {
        return studentActive;
    }

    public void setStudentActive(boolean studentActive) {
        this.studentActive = studentActive;
    }
}
