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
    static void validateUserNumberOfString(String userNumberOfString) throws IllegalArgumentException{
        validateOf3DigitsNumber(userNumberOfString);
        validateIsNumberOfStringHaveDifferentEach(userNumberOfString);
    }

    static void validateOneIfGameRepeatOrTwo(String oneIfGameRepeatOrTwo) throws IllegalArgumentException{
        if (ValidationConstant.INPUT_LIST_OF_USER_CHECK_REPEAT_GAME.contains(oneIfGameRepeatOrTwo)) {
            return;
        }
        throw new IllegalArgumentException(ValidationMessage.USER_CHECK_REPEAT_GAME_RULE_ANNOUNCEMENT);
    }

    private static void validateOf3DigitsNumber(String userNumberOfString) {
        boolean isMatch = Pattern.matches(ValidationConstant.USER_NUMBER_REGEX, userNumberOfString);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException(ValidationMessage.USER_NUMBER_RULE_ANNOUNCEMENT);
    }

    private static void validateIsNumberOfStringHaveDifferentEach(String numberOfString) {
        List<Integer> numberOfList = convertNumberOfStringToList(numberOfString);
        if (checkHaveListDuplication(numberOfList)) {
            throw new IllegalArgumentException(ValidationMessage.USER_NUMBER_RULE_ANNOUNCEMENT);
        };

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
