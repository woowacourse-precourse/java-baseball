package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private int strike;
    private int ball;

    public void setHintCount(List<Integer> computerNumbers, String playerNumber) {
        List<Integer> playerNumbers = toIntegerList(playerNumber);

        resetCount();
        countStrike(computerNumbers, playerNumbers);
        countBall(computerNumbers, playerNumbers);
        deduplicateCount();
    }

    private List<Integer> toIntegerList(String playerNumber) {
        String[] digits = playerNumber.split("");
        List<String> playerNumbers = new ArrayList<>(Arrays.asList(digits));

        return playerNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
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

    public void validateNumber(String playerNumber) {
        if (!isValidType(playerNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidLength(playerNumber)) {
            throw new IllegalArgumentException(Message.LENGTH_EXCEPTION);
        }

        if (!isValidDuplication(playerNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATION_EXCEPTION);
        }

        if (!isValidRange(playerNumber)) {
            throw new IllegalArgumentException(Message.RANGE_EXCEPTION);
        }
    }

    private boolean isValidType(String playerNumber) {
        for (char digit : playerNumber.toCharArray()) {
            if (Character.isLetter(digit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidLength(String playerNumber) {
        return playerNumber.length() == Config.DIGIT_SIZE;
    }

    private boolean isValidDuplication(String playerNumber) {
        String[] digits = playerNumber.split("");
        Set<String> deduplicationNumbers = new HashSet<>(Arrays.asList(digits));

        return playerNumber.length() == deduplicationNumbers.size();
    }

    private boolean isValidRange(String playerNumber) {
        for (char digit : playerNumber.toCharArray()) {
            int digitNumber = Character.getNumericValue(digit);

            if (Config.MIN_NUM > digitNumber || Config.MAX_NUM < digitNumber) {
                return false;
            }
        }
        return true;
    }
}
