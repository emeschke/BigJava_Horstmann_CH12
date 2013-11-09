package P12_6;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    //Student class is a student with a name and a level.  There is a special method that increments the student level
    //by one.
    private String studentName;
    private int studentLevel;



    public int getStudentLevel() {
        return studentLevel;
    }

    public void incrementStudentLevel() {
        this.studentLevel = studentLevel + 1;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
