package baseball;


import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        int[] computerNumber;
        int[] userNumber;

        Number answerNumber = new Number();
        Number userPrediction = new Number();

        answerNumber.setRandomNumber();
        computerNumber = answerNumber.getDigits();

        System.out.println(Arrays.toString(computerNumber));

        userPrediction.inputPrediction();
        userNumber = userPrediction.getDigits();

        System.out.println(Arrays.toString(userNumber));

    }

}