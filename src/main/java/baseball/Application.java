package baseball;


public class Application {

    public static void main(String[] args) {
        int[] computerNumber;

        Number answerNumber = new Number();
        Number userPrediction = new Number();
        // 그냥 Number class 로 출력하면 주소값이 나오기 때문에
        // Array 형식으로 바꾼다.
        answerNumber.setRandomNumber();
        computerNumber = answerNumber.getDigits();

    }

}