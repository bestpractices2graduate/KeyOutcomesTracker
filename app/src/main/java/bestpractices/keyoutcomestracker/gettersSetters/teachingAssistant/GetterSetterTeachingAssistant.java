package bestpractices.keyoutcomestracker.gettersSetters.teachingAssistant;


public class GetterSetterTeachingAssistant {
    private int idTeachingAssistant = 0;
    private String teachingAssistantFirstName = null;
    private String teachingAssistantLastName = null;
    private String teachingAssistantOfficeNumber = null;
    private String teachingAssistantBuilding = null;
    private String teachingAssistantEmailAddress = null;
    private String teachingAssistantPhoneNumber = null;
    private boolean teachingAssistantActive;

    public GetterSetterTeachingAssistant() {

    }

    public GetterSetterTeachingAssistant(int idTeachingAssistant, String teachingAssistantFirstName, String teachingAssistantLastName, String teachingAssistantOfficeNumber, String teachingAssistantBuilding, String teachingAssistantEmailAddress, String teachingAssistantPhoneNumber) {
        this.idTeachingAssistant = idTeachingAssistant;
        this.teachingAssistantFirstName = teachingAssistantFirstName;
        this.teachingAssistantLastName = teachingAssistantLastName;
        this.teachingAssistantOfficeNumber = teachingAssistantOfficeNumber;
        this.teachingAssistantBuilding = teachingAssistantBuilding;
        this.teachingAssistantEmailAddress = teachingAssistantEmailAddress;
        this.teachingAssistantPhoneNumber = teachingAssistantPhoneNumber;
    }

    public GetterSetterTeachingAssistant(String teachingAssistantFirstName, String teachingAssistantLastName, String teachingAssistantOfficeNumber, String teachingAssistantBuilding, String teachingAssistantEmailAddress, String teachingAssistantPhoneNumber) {
        this.teachingAssistantFirstName = teachingAssistantFirstName;
        this.teachingAssistantLastName = teachingAssistantLastName;
        this.teachingAssistantOfficeNumber = teachingAssistantOfficeNumber;
        this.teachingAssistantBuilding = teachingAssistantBuilding;
        this.teachingAssistantEmailAddress = teachingAssistantEmailAddress;
        this.teachingAssistantPhoneNumber = teachingAssistantPhoneNumber;
    }

    public int getIdTeachingAssistant() {
        return idTeachingAssistant;
    }

    public void setIdTeachingAssistant(int idTeachingAssistant) {
        this.idTeachingAssistant = idTeachingAssistant;
    }

    public String getTeachingAssistantFirstName() {
        return teachingAssistantFirstName;
    }

    public void setTeachingAssistantFirstName(String teachingAssistantFirstName) {
        this.teachingAssistantFirstName = teachingAssistantFirstName;
    }

    public String getTeachingAssistantLastName() {
        return teachingAssistantLastName;
    }

    public void setTeachingAssistantLastName(String teachingAssistantLastName) {
        this.teachingAssistantLastName = teachingAssistantLastName;
    }

    public String getTeachingAssistantOfficeNumber() {
        return teachingAssistantOfficeNumber;
    }

    public void setTeachingAssistantOfficeNumber(String teachingAssistantOfficeNumber) {
        this.teachingAssistantOfficeNumber = teachingAssistantOfficeNumber;
    }

    public String getTeachingAssistantBuilding() {
        return teachingAssistantBuilding;
    }

    public void setTeachingAssistantBuilding(String teachingAssistantBuilding) {
        this.teachingAssistantBuilding = teachingAssistantBuilding;
    }

    public String getTeachingAssistantEmailAddress() {
        return teachingAssistantEmailAddress;
    }

    public void setTeachingAssistantEmailAddress(String teachingAssistantEmailAddress) {
        this.teachingAssistantEmailAddress = teachingAssistantEmailAddress;
    }

    public String getTeachingAssistantPhoneNumber() {
        return teachingAssistantPhoneNumber;
    }

    public void setTeachingAssistantPhoneNumber(String teachingAssistantPhoneNumber) {
        this.teachingAssistantPhoneNumber = teachingAssistantPhoneNumber;
    }

    public boolean isTeachingAssistantActive() {
        return teachingAssistantActive;
    }

    public void setTeachingAssistantActive(boolean teachingAssistantActive) {
        this.teachingAssistantActive = teachingAssistantActive;
    }
}
