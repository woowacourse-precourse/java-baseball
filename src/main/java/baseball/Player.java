package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private int strike;
    private int ball;

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

    public void validatePlayerNumber(String playerNumber) {
        if (!isValidType(playerNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidDigitLength(playerNumber)) {
            throw new IllegalArgumentException(Message.DIGIT_LENGTH_EXCEPTION);
        }

        if (!isValidDuplication(playerNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATION_EXCEPTION);
        }

        if (!isValidRange(playerNumber)) {
            throw new IllegalArgumentException(Message.DIGIT_RANGE_EXCEPTION);
        }
    }

    private boolean isValidType(String number) {
        for (char digit : number.toCharArray()) {
            if (Character.isLetter(digit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidDigitLength(String playerNumber) {
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

            if (Config.DIGIT_MIN > digitNumber || Config.DIGIT_MAX < digitNumber) {
                return false;
            }
        }
        return true;
    }

    public void validateStateNumber(String stateNumber) {
        if (!isValidType(stateNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidStateLength(stateNumber)) {
            throw new IllegalArgumentException(Message.STATE_LENGTH_EXCEPTION);
        }

        if (!isValidNumber(stateNumber)) {
            throw new IllegalArgumentException(Message.STATE_NUMBER_EXCEPTION);
        }
    }

    private boolean isValidStateLength(String stateNumber) {
        return stateNumber.length() == Config.STATE_SIZE;
    }

    private boolean isValidNumber(String stateNumber) {
        for (State state : State.values()) {
            if(state.getNumber().equals(stateNumber)) {
                return true;
            }
        }

        return false;
    }
}