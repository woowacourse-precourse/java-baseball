package baseball.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class PlayerNumber implements Number {
    List<String> playNumber;

    public PlayerNumber(String number) throws IllegalArgumentException  {
        checkValidation(number);
        this.playNumber = new ArrayList<>(Arrays.asList(number.split("")));
    }

    @Override
    public List<String> getNumber() {
        return playNumber;
    }

    public void checkValidation(String number) throws IllegalArgumentException{
        checkValidateNumber(number);
        checkDuplicateNumber(number);
    }

    private int checkValidateNumber(String number) throws IllegalArgumentException{
        String regExp = "\\d{3}";

        if (Pattern.matches(regExp, number)) {
            return 0;
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

    public static void main(String[] args) {
        PlayerNumber playerNumber = new PlayerNumber("간다");
    }

}
