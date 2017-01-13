package bestpractices.keyoutcomestracker.gettersSetters.instructor;

public class GetterSetterInstructor {

    private int idInstructor = 0;
    private String instructorFirstName = null;
    private String instructorLastName = null;
    private String instructorOfficeNumber = null;
    private String instructorBuilding = null;
    private String instructorEmailAddress = null;
    private String instructorPhoneNumber = null;
    private boolean instructorActive;

    public GetterSetterInstructor() {

    }

    public GetterSetterInstructor(int idInstructor, String instructorFirstName, String instructorLastName, String instructorOfficeNumber, String instructorBuilding, String instructorEmailAddress, String instructorPhoneNumber) {
        this.idInstructor = idInstructor;
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
        this.instructorOfficeNumber = instructorOfficeNumber;
        this.instructorBuilding = instructorBuilding;
        this.instructorEmailAddress = instructorEmailAddress;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    public GetterSetterInstructor(String instructorFirstName, String instructorLastName, String instructorOfficeNumber, String instructorBuilding, String instructorEmailAddress, String instructorPhoneNumber) {
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
        this.instructorOfficeNumber = instructorOfficeNumber;
        this.instructorBuilding = instructorBuilding;
        this.instructorEmailAddress = instructorEmailAddress;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getInstructorFirstName() {
        return instructorFirstName;
    }

    public void setInstructorFirstName(String instructorFirstName) {
        this.instructorFirstName = instructorFirstName;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public String getInstructorOfficeNumber() {
        return instructorOfficeNumber;
    }

    public void setInstructorOfficeNumber(String instructorOfficeNumber) {
        this.instructorOfficeNumber = instructorOfficeNumber;
    }

    public String getInstructorBuilding() {
        return instructorBuilding;
    }

    public void setInstructorBuilding(String instructorBuilding) {
        this.instructorBuilding = instructorBuilding;
    }

    public String getInstructorEmailAddress() {
        return instructorEmailAddress;
    }

    public void setInstructorEmailAddress(String instructorEmailAddress) {
        this.instructorEmailAddress = instructorEmailAddress;
    }

    public String getInstructorPhoneNumber() {
        return instructorPhoneNumber;
    }

    public void setInstructorPhoneNumber(String instructorPhoneNumber) {
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    public boolean isInstructorActive() {
        return instructorActive;
    }

    public void setInstructorActive(boolean instructorActive) {
        this.instructorActive = instructorActive;
    }
}
