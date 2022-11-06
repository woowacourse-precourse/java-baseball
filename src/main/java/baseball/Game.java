package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class Game {

    public void startGame() {
        User user = new User();
        Computer computer = new Computer();

        System.out.println(START_PROGRAM);

        List<Integer> computerNumber = computer.setRandomNumber();
        String userNumber = user.inputNumber();
        System.out.println(getHint(userNumber, computerNumber));

    }

    public String getHint(String userNumber, List<Integer> computerNumber) {

        List<Integer> scoreList = calculateScore(userNumber, computerNumber);
        StringBuilder sb = new StringBuilder();

        if(scoreList.get(0) == 0 && scoreList.get(1) == 0) {
            return NOTHING;
        }
        if(scoreList.get(0) > 0) {
            sb.append(scoreList.get(0)).append(BALL);
        }
        if(scoreList.get(1) > 0) {
            sb.append(scoreList.get(1)).append(STRIKE);
        }
        return sb.toString();
    }

    private List<Integer> calculateScore(String userNumber, List<Integer> computerNumber) {

        int ballCount = getBallCount(userNumber, computerNumber);
        int strikeCount = getStrikeCount(userNumber, computerNumber);

        return List.of(ballCount - strikeCount, strikeCount);
    }

    private int getBallCount(String userNumber, List<Integer> computerNumber) {
        int ball = 0;

        for (int i = 0; i < CNT_NUMBER; i++) {
            if (computerNumber.contains(Character.getNumericValue(userNumber.charAt(i))))
                ball += 1;
        }
        return ball;
    }

    private int getStrikeCount(String userNumber, List<Integer> computerNumber) {
        int strike = 0;

        for (int i = 0; i < CNT_NUMBER; i++) {
            if (computerNumber.get(i) == (Character.getNumericValue(userNumber.charAt(i))))
                strike += 1;
        }
        return strike;
    }

}
