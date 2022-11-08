package baseball.controller;

import baseball.constant.ValidationConstant;
import baseball.constant.ValidationMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExceptionHandler {
    static void validateUserNumberOfString(String userNumberOfString) throws IllegalArgumentException {
        validateHaveNumber3Digits(userNumberOfString);
        validateIsNumberOfStringNotHaveDuplicatedNumber(userNumberOfString);
    }

    static void validateOneIfGameRepeatOrTwo(String oneIfGameRepeatOrTwo) throws IllegalArgumentException {
        if (ValidationConstant.EXAMPLE_LIST_INPUT_OF_CHECK_REPEAT_GAME.contains(oneIfGameRepeatOrTwo)) {
            return;
        }
        throw new IllegalArgumentException(ValidationMessage.USER_INPUT_FOR_CHECK_REPEAT_GAME_RULE_ANNOUNCEMENT);
    }

    private static void validateHaveNumber3Digits(String userNumberOfString) {
        boolean isMatchWithValidationPattern = Pattern.matches(ValidationConstant.PATTERN_OF_INPUT_USER_NUMBER_REGEX, userNumberOfString);
        if (isMatchWithValidationPattern) {
            return;
        }
        throw new IllegalArgumentException(ValidationMessage.USER_INPUT_NUMBER_RULE_ANNOUNCEMENT);
    }

    private static void validateIsNumberOfStringNotHaveDuplicatedNumber(String numberOfString) {
        List<Integer> numberOfList = convertNumberOfStringToList(numberOfString);
        if (checkHaveListDuplication(numberOfList)) {
            throw new IllegalArgumentException(ValidationMessage.USER_INPUT_NUMBER_RULE_ANNOUNCEMENT);
        }
        ;
    }

    private static boolean checkHaveListDuplication(List<Integer> numberOfList) {
        Set<Integer> numberOfSet = new HashSet<>(numberOfList);
        int sizeOfOriginNumber = numberOfList.size();
        int sizeAfterDeleteDuplication = numberOfSet.size();
        if (sizeOfOriginNumber == sizeAfterDeleteDuplication) {
            return false;
        }
        return true;
    }

    private static List<Integer> convertNumberOfStringToList(String numberOfString) {
        List<String> numberOfStringList = new ArrayList<>(Arrays.asList(numberOfString.split("")));
        List<Integer> numberOfList = numberOfStringList.stream()
                .map(Integer::new)
                .collect(Collectors.toList());
        return numberOfList;
    }

}
