package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> playerNumbers;
    private int strike;
    private int ball;

    public Player() {
        playerNumbers = new ArrayList<>();
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setNumbers(String playerNumber) {
        this.playerNumbers = toIntegerList(playerNumber);
    }

    private List<Integer> toIntegerList(String playerNumber) {
        return Arrays.stream(playerNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void setHintCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        resetCount();
        countStrike(computerNumbers, playerNumbers);
        countBall(computerNumbers, playerNumbers);
        deduplicateCount();
    }

    private void resetCount() {
        strike = 0;
        ball = 0;
    }

    private void countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < Config.DIGIT_SIZE; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            }
        }
    }

    private void countBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < Config.DIGIT_SIZE; i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
    }

    private void deduplicateCount() {
        ball -= strike;
    }

    public String getHintMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        if (strike == 0 && ball == 0) {
            return Message.NOTHING;
        }

        if (ball > 0) {
            stringBuilder.append(ball).append(Message.BALL).append(Message.BLANK);
        }

        if (strike > 0) {
            stringBuilder.append(strike).append(Message.STRIKE);
        }

        return stringBuilder.toString().trim();
    }

    public boolean isMaxStrike() {
        return strike == Config.MAX_STRIKE;
    }
}