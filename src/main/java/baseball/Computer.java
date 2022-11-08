package baseball;

import static baseball.Command.RESTART;
import static baseball.Command.EXIT;
import static baseball.Range.START;
import static baseball.Range.END;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

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
            gameResultMessage.append(Message.NOTHING_MESSAGE);
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
    public Command getCommand(List<Integer> command) {
        Integer commandInt = command.get(0);
        int commandRestart = RESTART.getCommand();
        if (commandInt.equals(commandRestart)) {
            return RESTART;
        }
        return EXIT;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START.getPoint(), END.getPoint());
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
        System.out.println(Message.CORRECT_ANSWER_MESSAGE);
    }

}
