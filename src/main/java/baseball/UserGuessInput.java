package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class UserGuessInput{
    private List<Integer> input;

    protected UserGuessInput() {
        this.input = processUserInput();
    }

    protected List<Integer> getUserGuess(){
        return this.input;
    }

    protected List<Integer> processUserInput(){
        return processGuess();
    }

    protected List<Integer> processGuess(){
        System.out.println("숫자를 입력해주세요:");
        String inputString = Console.readLine();
        return convertStringToList(inputString);
    }

    protected List<Integer> convertStringToList(String inputString){
        List<Integer> convertedList = Arrays.stream(inputString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return convertedList;
    }
}