package baseball;



public class Application {

    public static void main(String[] args) {

        int[] computerNumber;
        int[] userNumber;

        Number answerNumber = new Number();
        Number userPrediction = new Number();

        answerNumber.setRandomNumber();
        computerNumber = answerNumber.getDigits();


        userPrediction.inputPrediction();
        userNumber = userPrediction.getDigits();

    }

}