package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseBallGame {
    private String randomNumber;
    private String userInputValue;

    private static final int MAX_LENGTH = 3;

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public void startGame() {
        printStartMessage();
        initRandomNumber();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START.getText());
    }

    private void initRandomNumber() {
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomValue)) {
                randomList.add(randomValue);
                randomNumber = randomNumber.concat(String.valueOf(randomValue));
            }
        }
    }

    public void getInputValue() {
        String inputString = Console.readLine();
        if (!checkInputValue(inputString)) {
            throw new IllegalArgumentException();
        }

        System.out.print(GameMessage.INPUT_VALUE.getText());
        userInputValue = Console.readLine();
    }

    private boolean checkInputValue(String inputValue) {
        if (isEmpty(inputValue)) {
            return false;
        }

        if (isLong(inputValue)) {
            return false;
        }

        if (isNumeric(inputValue)) {
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
    private boolean isLong(String inputValue) {
        if (!(inputValue.length() > MAX_LENGTH)) {
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

    public boolean isAnswer() {
        return false;
    }
}
