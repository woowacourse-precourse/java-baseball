package baseball.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class PlayerNumber implements Number {
    List<String> playNumber;

    public PlayerNumber(String number) throws IllegalArgumentException  {
        chkValidation(number);
        this.playNumber = new ArrayList<>(Arrays.asList(number.split("")));
    }

    @Override
    public List<String> getNumber() {

        return playNumber;
    }

    public void chkValidation(String number) throws IllegalArgumentException{
        isNumber(number);
        isDuplicate(number);
    }

    private int isNumber(String number) throws IllegalArgumentException{
        String regExp = "\\d{3}";

        if (Pattern.matches(regExp, number)) {
            System.out.println("pass");
            return 0;
        }
        throw new IllegalArgumentException();
    }

    private void isDuplicate(String number) throws IllegalArgumentException {
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
