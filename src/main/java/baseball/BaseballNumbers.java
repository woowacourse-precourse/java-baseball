package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class BaseballNumbers {
    private static final boolean CREATE_BASEBALL_NUMBERS = true;
    private static final boolean DO_COMMAND_RECORDS = false;
    private static final String RECORDS = "records";


    private List<BaseballNumber> baseballNumbers;

    public boolean isNumericReadline(String readline) {
        return Pattern.matches("^[1-9]{3}", readline);
    }

    public boolean isCommandReadline(String readline) {
        return Pattern.matches(RECORDS, readline.toLowerCase());
    }

    public boolean validateReadline(String readline) {
        return isNumericReadline(readline) || isCommandReadline(readline);
    }

    public boolean checkReadline(String readline) throws IllegalArgumentException {
        if (!validateReadline(readline)) {
            throw new IllegalArgumentException("This string does not match either numbers or commands.");
        }
        return isNumericReadline(readline);
    }

    public boolean validateDuplication() throws IllegalArgumentException {
        Set<Integer> checkUniqueSet = new HashSet<>();

        for (int index = BaseballConstants.FIRST_INDEX_OF_BASEBALL_NUMBER; index < BaseballConstants.LAST_INDEX_OF_BASEBALL_NUMBER; index++) {
            checkUniqueSet.add(baseballNumbers.get(index).getBaseballNumber(index));
        }
        if (checkUniqueSet.size() != baseballNumbers.size()) {
            throw new IllegalArgumentException("Some numbers have a duplication.");
        }
        return CREATE_BASEBALL_NUMBERS;
    }

    public void putBaseballNumbers(String[] baseballNumberList) {
        baseballNumbers = new ArrayList<>();
        for (int index = BaseballConstants.FIRST_INDEX_OF_BASEBALL_NUMBER; index < BaseballConstants.LAST_INDEX_OF_BASEBALL_NUMBER; index++) {
            BaseballNumber baseballNumber = new BaseballNumber(baseballNumberList[index], index);
            baseballNumbers.add(baseballNumber);
        }
    }

    public boolean createBaseballNumbers(String readline) {
        if (checkReadline(readline)) {
            putBaseballNumbers(readline.split("(?<=.)"));
            return validateDuplication();
        }
        return DO_COMMAND_RECORDS;
    }

    public int get(int index) {
        return baseballNumbers.get(index).getBaseballNumber(index);
    }

}
