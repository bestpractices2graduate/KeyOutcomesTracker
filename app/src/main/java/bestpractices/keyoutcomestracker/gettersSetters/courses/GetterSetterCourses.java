package bestpractices.keyoutcomestracker.gettersSetters.courses;


public class GetterSetterCourses {

    private int idCourses;
    private String courseNumber;
    private String courseName;
    private String courseDescription;
    private String courseRoomNumber;
    private String courseInstructor;
    private String courseTeachingAssistant;
    private String courseSemesterStartDate;
    private String courseSemesterEndDate;
    private String courseDays;
    private String courseLectureStartTime;
    private String courseLectureEndTime;

    private boolean coursesActive;


    public GetterSetterCourses() {

    }

    public GetterSetterCourses(int idCourses,
                               String courseNumber,
                               String courseName,
                               String courseDescription,
                               String courseRoomNumber,
                               String courseInstructor,
                               String courseTeachingAssistant,
                               String courseSemesterStartDate,
                               String courseSemesterEndDate,
                               String courseDays,
                               String courseLectureStartTime,
                               String courseLectureEndTime) {

        this.idCourses = idCourses;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseRoomNumber = courseRoomNumber;
        this.courseInstructor = courseInstructor;
        this.courseTeachingAssistant = courseTeachingAssistant;
        this.courseSemesterStartDate = courseSemesterStartDate;
        this.courseSemesterEndDate = courseSemesterEndDate;
        this.courseDays = courseDays;
        this.courseLectureStartTime = courseLectureStartTime;
        this.courseLectureEndTime = courseLectureEndTime;

    }

    public GetterSetterCourses(String courseNumber,
                               String courseName,
                               String courseDescription,
                               String courseRoomNumber,
                               String courseInstructor,
                               String courseTeachingAssistant,
                               String courseSemesterStartDate,
                               String courseSemesterEndDate,
                               String courseDays,
                               String courseLectureStartTime,
                               String courseLectureEndTime) {

        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseRoomNumber = courseRoomNumber;
        this.courseInstructor = courseInstructor;
        this.courseTeachingAssistant = courseTeachingAssistant;
        this.courseSemesterStartDate = courseSemesterStartDate;
        this.courseSemesterEndDate = courseSemesterEndDate;
        this.courseDays = courseDays;
        this.courseLectureStartTime = courseLectureStartTime;
        this.courseLectureEndTime = courseLectureEndTime;
    }

    public int getIdCourses() {
        return idCourses;
    }

    public void setIdCourses(int idCourses) {
        this.idCourses = idCourses;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseRoomNumber() {
        return courseRoomNumber;
    }

    public void setCourseRoomNumber(String courseRoomNumber) {
        this.courseRoomNumber = courseRoomNumber;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getCourseTeachingAssistant() {
        return courseTeachingAssistant;
    }

    public void setCourseTeachingAssistant(String courseTeachingAssistant) {
        this.courseTeachingAssistant = courseTeachingAssistant;
    }

    public String getCourseSemesterStartDate() {
        return courseSemesterStartDate;
    }

    public void setCourseSemesterStartDate(String courseSemesterStartDate) {
        this.courseSemesterStartDate = courseSemesterStartDate;
    }

    public String getCourseSemesterEndDate() {
        return courseSemesterEndDate;
    }

    public void setCourseSemesterEndDate(String courseSemesterEndDate) {
        this.courseSemesterEndDate = courseSemesterEndDate;
    }

    public String getCourseDays() {
        return courseDays;
    }

    public void setCourseDays(String courseDays) {
        this.courseDays = courseDays;
    }

    public String getCourseLectureStartTime() {
        return courseLectureStartTime;
    }

    public void setCourseLectureStartTime(String courseLectureStartTime) {
        this.courseLectureStartTime = courseLectureStartTime;
    }

    public String getCourseLectureEndTime() {
        return courseLectureEndTime;
    }

    public void setCourseLectureEndTime(String courseLectureEndTime) {
        this.courseLectureEndTime = courseLectureEndTime;
    }

    public boolean isCoursesActive() {
        return coursesActive;
    }

    public void setCoursesActive(boolean coursesActive) {
        this.coursesActive = coursesActive;
    }
}
