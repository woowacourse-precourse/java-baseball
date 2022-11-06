package baseball;

import java.util.List;
import java.util.regex.Pattern;

public class BaseballNumbers {
    private List<BaseballNumber> baseballNumbers;

    public boolean isNumericReadline(String readline) {
        return Pattern.matches("^[1-9]{3}", readline);
    }

    public boolean isCommandReadline(String readline) {
        return Pattern.matches(BaseballConstants.RECORDS, readline.toLowerCase());
    }

    public boolean validCheck(String readline) {
        return isNumericReadline(readline) || isCommandReadline(readline);
    }

    public boolean checkReadline(String readline) throws IllegalArgumentException {
        if (!validCheck(readline)) {
            throw new IllegalArgumentException();
        }
        return isNumericReadline(readline);
    }

}
