package baseball.model;

import java.util.List;

public class Calculator {
    private final static int SIZE = 3;
    private final static String BALL_SUFFIX = "볼";
    private final static String STRIKE_SUFFIX = "스트라이크";
    private final static String NOTHING = "낫싱";
    private final List<Integer> randomNumbers;
    private final List<Integer> userNumbers;
    private final Count ballAndStrike;

    public Calculator(List<Integer> randomNumbers, List<Integer> userNumbers){
        this.randomNumbers = randomNumbers;
        this.userNumbers = userNumbers;
        this.ballAndStrike = new Count();
    }

    public String calculate(){
        for (int i=0; i <SIZE; i++){
            int userNumber = userNumbers.get(i);
            if (randomNumbers.contains(userNumber)){
                count(userNumber);
            }
        }
        return makeCountMessage();
    }

    private String makeCountMessage(){
        int ballCount = ballAndStrike.getBallCount();
        int strikeCount = ballAndStrike.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0){
            return NOTHING + "\n";
        }
        if (ballCount != 0 && strikeCount == 0){
            return ballCount + BALL_SUFFIX + "\n";
        }
        if (ballCount == 0 && strikeCount != 0){
            return strikeCount + STRIKE_SUFFIX + "\n";
        }
        return ballCount + BALL_SUFFIX + " " + strikeCount + STRIKE_SUFFIX + "\n";
    }

    private void count(int userNumber){
        if(randomNumbers.indexOf(userNumber) == userNumbers.indexOf(userNumber)){
            ballAndStrike.countStrike();
            return;
        }
        ballAndStrike.countBall();
    }
}
