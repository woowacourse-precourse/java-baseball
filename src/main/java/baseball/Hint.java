package baseball;

public class Hint {
    private int strike;
    private int ball;

    public void getHint(int[] userNumber, int[] computerNumber){
        for (int i = 0; i < 3; i++){
            countStrike(userNumber[i], computerNumber[i]);
            countBall(userNumber[i], computerNumber, i);
        }
    }

}
