package baseball.number;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class PlayerNumber implements Number {
    List<String> playNumber;

    @Override
    public List<String> getNumber() {
        return playNumber;
    }

    public void setPlayerNumber() throws IllegalArgumentException {
        String number = enterPlayerNumber();
        checkValidation(number);
        this.playNumber = new ArrayList<>(Arrays.asList(number.split("")));
    }

    public String enterPlayerNumber() {
        String playerNumber;

        System.out.println("숫자를 입력해주세요 : ");
        playerNumber = Console.readLine();

        return playerNumber;
    }

    public void checkValidation(String number) throws IllegalArgumentException {
        checkValidateNumber(number);
        checkDuplicateNumber(number);
    }

    private void checkValidateNumber(String number) throws IllegalArgumentException {
        String regExp = "\\d{3}";

        if (Pattern.matches(regExp, number)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkDuplicateNumber(String number) throws IllegalArgumentException {
        List<String> numberArr = new ArrayList<>(Arrays.asList(number.split("")));

        for (String num : numberArr) {
            if (Collections.frequency(numberArr, num) != 1) {
                throw new IllegalArgumentException();
            }
        }
    }
}
