package P12_6;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 * The driver creates a Student and a Tester object.  The Tester takes a student object.  The tester is on a loop which
 * runs until the student has passed all the levels.  It calls runTester, a method which creates a level-appropriate
 * test question and quizzes the student.  When the student has passed all three level the quiz ends.
 *
 * No bugs that I can find.  Please note that a level two question could sum to less than 10 because it is any two
 * one digit numbers, not necessarily two that sum to >10.  Question values are randomized, so run it a couple of times
 * to find a level 2 question that sums to more than 10.
 *
 */
public class Driver {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner in = new Scanner(System.in);
        Tester tester = new Tester(student);
        System.out.printf("Student, please enter your name:");
        student.setStudentName(in.nextLine());

        while(student.getStudentLevel() < 3){
            System.out.println("Level: " + (student.getStudentLevel()+1));
            tester.runTester();
        }

        System.out.println("Great job.  You passed all the levels!");

    }
}
