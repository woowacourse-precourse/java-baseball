package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    public static List<Integer> guessAnswerOfGame() throws IllegalArgumentException{
        String playerInput = Console.readLine();
        if(!isValidInput(playerInput)){
            String message = "잘못된 입력: 1부터 9까지 자연수 중, 서로 다른 세 개의 수를 입력해주세요.";
            throw new IllegalArgumentException(message);
        }
        return convertStringToIntegerList(playerInput);
    }
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
