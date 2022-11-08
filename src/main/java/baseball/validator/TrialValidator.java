package baseball.validator;

import baseball.exception.CantBlankOrNullInputException;
import baseball.exception.CantDuplicatedNumberInputException;
import baseball.exception.OnlyNumberConsistBetweenOneToNineInputException;
import baseball.exception.OnlyThreeNumberInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TrialValidator {

    private TrialValidator(){

    }
    private static final int MAX_NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEXP = "^[1-9]+$";
    private static final String SPLIT_REGEXP = "";

    public static void validate(String input) {
        validateBlank(input);
        isNumberBetweenOneToNine(input);
        validateNumberLength(input);
        validateDuplicateNumber(input);
    }

    public static void isNumberBetweenOneToNine(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new OnlyNumberConsistBetweenOneToNineInputException();
        }
    }

    public static void validateNumberLength(String input) {
        if (input.length() != MAX_NUMBER_LENGTH) {
            throw new OnlyThreeNumberInputException();
        }
    }

    public static void validateDuplicateNumber(String input) {
        List<String> characterList = Arrays.asList(input.split(SPLIT_REGEXP));
        if (hasDuplicatedDigit(characterList)) {
            throw new CantDuplicatedNumberInputException();
        }
    }

    private static boolean hasDuplicatedDigit(List<String> characterList) {
        return characterList.size() != characterList.stream().distinct().count();
    }

    private static void validateBlank(final String input){
        if (isBlank(input)){
            throw new CantBlankOrNullInputException();
        }
    }

    private static boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
