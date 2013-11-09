package P12_6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
Tester class has a student and creates a series of questions.  As an input to the constructor it takes a student and
sets the level based on the student's level.   The runTester method creates a question according to the student's level
 and then runs until two answers are entered or the question is correct.  Every time the runTester method is called a
 new question object is created.  This is necessary to create a new set of random numbers.


 */
public class Tester {
    private Student student;
    private int level;
    private int tries = 0;
    private Scanner in = new Scanner(System.in);
    private Question question;

    public Tester(Student student){
        this.student = student;
        level = student.getStudentLevel();

    }

    public void runTester(){
        //Run the tester that is appropriate for the student.  The tester generates a question that is the correct level.
        //It then calls a method to read in the student's input, checks that it is valid and then checks the answer.
        level = student.getStudentLevel();
        Question question = new Question(level);
        while (tries < 2){
            System.out.printf(question.getQuestion());
            //Use the getAnswerText method to read in the text.  It either returns a valid answer or -1.  -1 can never
            //be a correct answer, so if that is returned the checkAnswer method will fail.
            if (question.checkAnswer(getAnswerText())){
                student.incrementStudentLevel();
                tries = 0;
                return;
            }
            else{
                System.out.println("Answer is not correct.  Try again.");
                tries += 1;
            }
        }
        tries = 0;
        System.out.println("No luck after two tries.  Moving on to a new question.");
    }

    public int getAnswerText(){
        //Validate the input and return an int for the input or -1 if it doesn't work.
        int guess;
        try{
            guess = Integer.parseInt(in.next());
            return guess;
        }catch(NumberFormatException e){
            System.out.println("Not a valid guess.");
            return -1;
        }
    }
}
