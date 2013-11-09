package P12_6;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 8:42 AM
 * To change this template use File | Settings | File Templates.
The question object takes a level (0,1,2) and creates a question accordingly.  Within the constructor, the level creates
random numbers according to a formula depending on the level so the random numbers fit the constraints of the level.


 */
public class Question {
    private int level;
    private int number1;
    private int number2;
    private int answer;
    private String question;

    public Question(int level){
        //In constructor set the level from an int that is passed.  Generate and set the two numbers and also the
        //answer based on the description of each level and random number generation.
        this.level = level;
        if (level == 0){
        //Choose a random number between 0 and 9.  Then choose a second one such that the sum is less than 10.
            number1 = (int) (Math.random()*10);
            number2 = (int) (Math.random()*(10-number1));
            answer = number1 + number2;
        }

        if (level == 1){
        //Choose any two (positive) one digit numbers.
            number1 = (int) (Math.random()*10);
            number2 = (int) (Math.random()*10);
            answer = number1 + number2;
        }

        if (level == 2){
        //Choose two random numbers.  When creating the answer, subtract the larger from the smaller.
            number1 = (int) (Math.random()*10);
            number2 = (int) (Math.random()*10);
            answer = Math.max(number1, number2) - Math.min(number1, number2);
        }
    }

    public String getQuestion(){
        //Return a string that is the question.  Prints max, min if the problem is a subtraction one.
        if (level == 0 || level == 1){
            question = "What is the answer to " + number1 + " + " + number2 + ": ";
        }
        if (level == 2){
            question = "What is the answer to " + Math.max(number1,number2) + " - " + Math.min(number1,number2) + ": ";

        }

        return question;
    }

    public boolean checkAnswer(int testAnswer){
    //Boolean returns true or false depending on whether the answer is true.
        if (answer == testAnswer){
            return true;
        }
        return false;
    }

    public int getAnswer(){
        return answer;
    }
}
