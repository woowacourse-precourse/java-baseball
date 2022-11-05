package baseball.number;

import java.util.ArrayList;
import java.util.Arrays;
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

    private void chkValidation(String number) throws IllegalArgumentException{
        isNumber(number);
    }

    private void isNumber(String number) throws IllegalArgumentException{
        String regExp = "\\d{3}";

        if (Pattern.matches(regExp, number)) {
            System.out.println("pass");
        } else{
            throw new IllegalArgumentException();
        }
    }

}
