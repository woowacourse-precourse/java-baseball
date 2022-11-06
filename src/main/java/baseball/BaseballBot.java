package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballBot {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int NUM_LENGTH = 3;

    private static final String STRIKE_STR = "스트라이크 ";
    private static final String BALL_STR = "볼 ";
    private static final String NOTHING_STR = "낫싱";
    private static final String GAME_END_STR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private String answer = "";

    private boolean gameEnd = false;

    public void createRandomValue() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int randomNumber : computer) {
            answer += randomNumber;
        }
    }

    public String checkHint(String userInput) {
        int strike = getStrikeNum(userInput);
        int ball = getBallNum(userInput, strike);
        checkEnd(strike);

        return createHintStr(strike, ball);
    }

    private int getStrikeNum(String userInput) {
        int strike = 0;

        for (int i = 0; i < NUM_LENGTH; i++) {
            if (answer.charAt(i) == userInput.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    private int getBallNum(String userInput, int strike) {
        int sameNumberCount = 0;

        for (int i = 0; i < NUM_LENGTH; i++) {
            char curChar = userInput.charAt(i);

            if (answer.contains(String.valueOf(curChar))) {
                sameNumberCount++;
            }
        }

        //같은 숫자가 나오는 경우는 스트라이크이거나 볼일 경우 두 가지이다
        //따라서 (볼의 개수) = (같은 숫자의 개수) - (스트라이크 개수)
        return sameNumberCount - strike;
    }

    private void checkEnd(int strike) {
        if (strike == 3) {
            gameEnd = true;
        }
    }

    private String createHintStr(int strike, int ball) {
        StringBuilder hintStr = new StringBuilder();

        if (strike == 0 && ball == 0) {
            hintStr.append(NOTHING_STR);
        }

        if (ball > 0) {
            hintStr.append(ball).append(BALL_STR);
        }

        if (strike > 0) {
            hintStr.append(strike).append(STRIKE_STR);
        }

        if (isGameEnd()) {
            hintStr.append("\n").append(GAME_END_STR);
        }

        return hintStr.toString();
    }

    public boolean isGameEnd() {
        return gameEnd;
    }
}
