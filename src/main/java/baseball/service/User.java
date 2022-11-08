package baseball.service;

import baseball.exception.CheckException;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> inputGuess() throws IOException {
        List<Integer> guess = new ArrayList<>();
        CheckException checkException = new CheckException();
        String[] inputArray = Console.readLine().split("");
        while(true) {
            try {
                checkException.validateInputLength(inputArray);
                checkException.validateInputNum(inputArray);
                checkException.validateInputDistinct(inputArray);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("숫자를 입력해주세요 : ");
                inputArray = Console.readLine().split("");
            }
        }

        for(String i : inputArray){
            guess.add(Integer.parseInt(i));
        }

        return guess;
    }

}
