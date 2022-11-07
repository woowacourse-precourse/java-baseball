package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    static boolean isValidInput(String playerInput){
        return isInputSizeEqualToAnswerSize(playerInput)
                && doesNotHaveDuplicateInputElement(playerInput)
                && hasOnlyNaturalNumberAsInput(playerInput);
    }
    static boolean isInputSizeEqualToAnswerSize(String playerInput){
        return playerInput.length() == Game.ANSWER_SIZE;
    }

    static boolean doesNotHaveDuplicateInputElement(String playerInput){
        List<String> guessTokenList = Arrays.asList(playerInput.split(""));
        Set<String> guessTokenSet = new HashSet<>(guessTokenList);

        return guessTokenList.size() == guessTokenSet.size();
    }

    static boolean hasOnlyNaturalNumberAsInput(String playerInput){
        char maxValueOfGame = Character.forDigit(Game.MAX_NUMBER_OF_ANSWER, 10);
        char minValueOfGame = Character.forDigit(Game.MIN_NUMBER_OF_ANSWER, 10);
        char[] guessTokenArray = playerInput.toCharArray();

        for(char token : guessTokenArray){
            if((token < minValueOfGame) || (token > maxValueOfGame)){
                return false;
            }
        }
        return true;
    }

    static List<Integer> convertStringToIntegerList(String playerInput) {
        return Arrays.stream(playerInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
