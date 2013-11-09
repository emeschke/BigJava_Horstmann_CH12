package P12_6;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner in = new Scanner(System.in);
        Tester tester = new Tester(student);
        System.out.printf("Student, please enter your name:");
        student.setStudentName(in.nextLine());

        while(student.getStudentLevel() < 3){
            System.out.println(student.getStudentLevel());
            tester.runTester();
        }

        System.out.println("Great job.  You passed all the levels!");

    }
}
