package P12_6;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private String studentName;
    private int studentLevel;

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

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

    private int tries;
}
