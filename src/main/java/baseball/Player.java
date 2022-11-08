package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    public static List<Integer> guessAnswerOfGame() throws IllegalArgumentException{
        String consoleInput = Console.readLine();
        if(!isValidInput(consoleInput)){
            String message = "잘못된 입력: 1부터 9까지 자연수 중, 서로 다른 세 개의 수를 입력해주세요.";
            throw new IllegalArgumentException(message);
        }
        return convertStringToIntegerList(consoleInput);
    }
    static boolean isValidInput(String consoleInput){
        return isInputSizeEqualToAnswerSize(consoleInput)
                && doesNotHaveDuplicateInputElement(consoleInput)
                && hasOnlyNaturalNumberAsInput(consoleInput);
    }
    private static boolean isInputSizeEqualToAnswerSize(String consoleInput){
        return consoleInput.length() == Game.ANSWER_SIZE;
    }

    private static boolean doesNotHaveDuplicateInputElement(String consoleInput){
        List<String> guessTokenList = Arrays.asList(consoleInput.split(""));
        Set<String> guessTokenSet = new HashSet<>(guessTokenList);

        return guessTokenList.size() == guessTokenSet.size();
    }

    private static boolean hasOnlyNaturalNumberAsInput(String consoleInput){
        char maxValueOfGame = Character.forDigit(Game.MAX_NUMBER_OF_ANSWER, 10);
        char minValueOfGame = Character.forDigit(Game.MIN_NUMBER_OF_ANSWER, 10);
        char[] guessTokenArray = consoleInput.toCharArray();

        for(char token : guessTokenArray){
            if((token < minValueOfGame) || (token > maxValueOfGame)){
                return false;
            }
        }
        return true;
    }

    static List<Integer> convertStringToIntegerList(String consoleInput) {
        return Arrays.stream(consoleInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
