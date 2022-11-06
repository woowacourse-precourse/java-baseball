package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseballNumbers {
    private static final boolean DO_COMMAND_RECORDS = false;
    private static final int FIRST_INDEX_OF_BASEBALLNUMBER = 0;
    private static final int LAST_INDEX_OF_BASEBALLNUMBER = 3;

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

    public boolean checkBaseballNumberDuplication() throws IllegalArgumentException {
        int first = baseballNumbers.get(0).getBaseballNumber(0);
        int second = baseballNumbers.get(1).getBaseballNumber(1);
        int third = baseballNumbers.get(2).getBaseballNumber(2);

        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public void putBaseballNumbers(String[] baseballNumberList) throws IllegalArgumentException {
        baseballNumbers = new ArrayList<>();
        for (int i = FIRST_INDEX_OF_BASEBALLNUMBER; i < LAST_INDEX_OF_BASEBALLNUMBER; i++) {
            BaseballNumber baseballNumber = new BaseballNumber(baseballNumberList[i], i++);
            baseballNumbers.add(baseballNumber);
        }
    }

    public boolean adjustBaseballNumbers(String readline) {
        if (checkReadline(readline)) {
            putBaseballNumbers(readline.split("(?<=.)"));
            return checkBaseballNumberDuplication();
        }
        return DO_COMMAND_RECORDS;
    }

}
