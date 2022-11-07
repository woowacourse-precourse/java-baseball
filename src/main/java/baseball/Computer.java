package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int RESTART_NUMBER = 1;
    private List<Integer> computerNumbers;
    private int strike;
    private int ball;

    public Computer() {
        setRandomNumber();
        clearScore();
    }

    public void setRandomNumber() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() != 3) {
            int randomNumber = getRandomNumber();
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public void calculateScore(List<Integer> userNumbers) {
        countStrike(userNumbers);
        countBall(userNumbers);
    }
    public void printResult() {
        StringBuilder gameResultMessage = new StringBuilder();
        if (ball > 0) {
            gameResultMessage.append(ball)
                    .append("볼 ");
        }
        if (strike > 0) {
            gameResultMessage.append(strike)
                    .append("스트라이크");
        }
        if (gameResultMessage.length() == 0) {
            gameResultMessage.append(NOTHING_MESSAGE);
        }
        System.out.println(gameResultMessage);
        if (isCorrectAnswer()) {
            printCorrectAnswerMessage();
        }
    }

    public boolean isCorrectAnswer() {
        return strike == 3;
    }

    public void clearScore() {
        strike = 0;
        ball = 0;
    }
    public boolean isRestart(List<Integer> exitStatus) {
        Integer status = exitStatus.get(0);
        return status.equals(RESTART_NUMBER);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANGE_START, RANGE_END);
    }

    private void countStrike(List<Integer> userNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            Integer computerNumber = computerNumbers.get(i);
            Integer userNumber = userNumbers.get(i);

            if (computerNumber.equals(userNumber)) {
                strike++;
            }
        }
    }

    private void countBall(List<Integer> userNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            Integer computerNumber = computerNumbers.get(i);
            Integer userNumber = userNumbers.get(i);

            if (!computerNumber.equals(userNumber) && computerNumbers.contains(userNumber)) {
                ball++;
            }
        }
    }

    private void printCorrectAnswerMessage() {
        System.out.println(CORRECT_ANSWER_MESSAGE);
    }

}
