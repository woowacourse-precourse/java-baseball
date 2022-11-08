package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Pattern;

public class BaseBallGame {
    private int randomNumber = 0;
    private int userInputValue = 0;

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
        randomNumber += Randoms.pickNumberInRange(1, 9) * 100;
        randomNumber += Randoms.pickNumberInRange(1, 9) * 10;
        randomNumber += Randoms.pickNumberInRange(1, 9);
    }

    public void getInputValue() {
        String inputString = Console.readLine();
        if (!checkInputValue(inputString)) {
            throw new IllegalArgumentException();
        }

        System.out.print(GameMessage.INPUT_VALUE.getText());
        userInputValue = Integer.parseInt(Console.readLine());
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

    public boolean isAnswer() {
        return false;
    }
}
