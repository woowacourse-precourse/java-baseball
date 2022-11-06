package baseball;

import java.util.ArrayList;
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

}
