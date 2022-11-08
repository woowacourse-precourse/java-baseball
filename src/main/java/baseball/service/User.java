package baseball.service;

import baseball.exception.InputLengthException;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<Integer> inputGuess() throws IOException {
        List<Integer> guess = new ArrayList<>();
        String[] inputArray = Console.readLine().split("");
        InputLengthException.isInputLengthThree(inputArray);

        for(String i : inputArray){
            guess.add(Integer.parseInt(i));
        }
        return guess;
    }
}
