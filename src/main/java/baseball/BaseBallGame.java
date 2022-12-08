package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BaseBallGame {
    private String randomNumber;
    private String userInputValue;

    private boolean isRepeat = false;

    private static final int MAX_LENGTH = 3;
    private static final int WIN_CONDITION = 3;

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public void startGame() {
        isRepeat = true;
        printStartMessage();
        initRandomNumber();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START.getText());
    }

    private void initRandomNumber() {
        List<Integer> randomList = new ArrayList<>();
        StringBuilder randomNumberBuilder = new StringBuilder();
        while (randomList.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomValue)) {
                randomList.add(randomValue);
                randomNumberBuilder.append(randomValue);
            }
        }

        randomNumber = randomNumberBuilder.toString();
    }

    public void getInputValue() {
        System.out.print(GameMessage.INPUT_VALUE.getText());
        userInputValue = Console.readLine();
        if (!checkInputValue(userInputValue)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkInputValue(String inputValue) {
        if (isEmpty(inputValue)) {
            return false;
        }

        if (!checkInputValueLength(inputValue)) {
            return false;
        }

        if (isNumeric(inputValue) && !isDuplicate(inputValue)) {
            return true;
        }

        return false;
    }

    private boolean isEmpty(String inputValue) {
        if (!inputValue.isEmpty()) {
            return false;
        }

        return true;
    }
    private boolean checkInputValueLength(String inputValue) {
        if ((inputValue.length() > MAX_LENGTH) || (inputValue.length() < MAX_LENGTH)) {
            return false;
        }

        return true;
    }
    private boolean isNumeric(String inputValue) {
        if (!pattern.matcher(inputValue).matches()) {
            return false;
        }

        return true;
    }

    private boolean isDuplicate(String inputValue) {
        long count = Arrays.stream(inputValue.split("")).distinct().count();

        return inputValue.length() != count;
    }

    public void checkResult() {
        int strikeCount = calculateStrike(userInputValue);
        int ballCount = calculateBall(userInputValue);

        System.out.println(formatResultMessage(strikeCount, ballCount));
        if (strikeCount >= WIN_CONDITION) {
            System.out.println(GameMessage.END.getText());
            isRepeat = false;
        }
    }

    private int calculateStrike(String userInputValue) {
        int strikeCount = 0;
        for (int searchIndex = 0; searchIndex < MAX_LENGTH; searchIndex++) {
            if (userInputValue.charAt(searchIndex) == randomNumber.charAt(searchIndex)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int calculateBall(String userInputValue) {
        int ballCount = 0;
        for (int searchIndex = 0; searchIndex < MAX_LENGTH; searchIndex++) {
            String cut = String.valueOf(userInputValue.charAt(searchIndex));
            String randomValueSplit = String.valueOf(randomNumber.charAt(searchIndex));
            if (randomNumber.contains(cut)
                    && !randomValueSplit.equals(cut)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private String formatResultMessage(int strikeCount, int ballCount) {
        StringBuilder resultMessage = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            resultMessage.append("낫싱");
        }

        if (ballCount > 0) {
            resultMessage.append(ballCount + "볼");
        }

        if (resultMessage.length() > 0) {
            resultMessage.append(" ");
        }

        if (strikeCount > 0) {
            resultMessage.append(strikeCount + "스트라이크");
        }

        return resultMessage.toString();
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void checkRestartGame() {
        System.out.println(GameMessage.RESTART_QUESTION.getText());
        userInputValue = Console.readLine().trim();

        if (!isNumeric(userInputValue)) {
            throw new IllegalArgumentException();
        }

        if (isEmpty(userInputValue)) {
            throw new IllegalArgumentException();
        }

        if (userInputValue.length() > 1) {
            throw new IllegalArgumentException();
        }

        if (isNumeric(userInputValue) && userInputValue.length() == 1) {
            if (userInputValue.equals("1")) {
                initRandomNumber();
                isRepeat = true;
            }

            if (userInputValue.equals("2")) {
                isRepeat = false;
            }
        }
    }
}
