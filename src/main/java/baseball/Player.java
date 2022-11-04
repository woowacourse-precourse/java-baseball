package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    public static final int PLAYER = 0;
    public static final int STATE = 1;
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

    public void validatePlayerNumber(String playerNumber) {
        if (!isValidType(playerNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidLength(playerNumber, PLAYER)) {
            throw new IllegalArgumentException(Message.DIGIT_LENGTH_EXCEPTION);
        }

        if (!isValidDuplication(playerNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATION_EXCEPTION);
        }

        if (!isValidRange(playerNumber)) {
            throw new IllegalArgumentException(Message.DIGIT_RANGE_EXCEPTION);
        }
    }

    public void validateStateNumber(String stateNumber) {
        if (!isValidType(stateNumber)) {
            throw new IllegalArgumentException(Message.TYPE_EXCEPTION);
        }

        if (!isValidLength(stateNumber, STATE)) {
            throw new IllegalArgumentException(Message.STATE_LENGTH_EXCEPTION);
        }

        if (!isValidNumber(stateNumber)) {
            throw new IllegalArgumentException(Message.STATE_NUMBER_EXCEPTION);
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

    private boolean isValidLength(String number, int type) {
        switch (type) {
            case PLAYER:
                return number.length() == Config.DIGIT_SIZE;

            case STATE:
                return number.length() == Config.STATE_SIZE;
        }

        return false;
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

    private boolean isValidNumber(String stateNumber) {
        int number = Integer.parseInt(stateNumber);
        return Config.STATE_RESTART == number || Config.STATE_SHUTDOWN == number;
    }
}