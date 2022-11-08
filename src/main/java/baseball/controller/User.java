package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import baseball.model.Baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    public Baseball getInput() {
        String input = Console.readLine();
        int inputNumber = strToInt(input);
        List<Integer> userNumber = mappingToList(inputNumber);
        return new  Baseball(userNumber);
    }

    private static int strToInt(String input) {
        int num = Integer.valueOf(input);
        return num;
    }
    private static List<Integer> mappingToList(int inputNumber) {
        List<Integer> userNumber = new ArrayList<>();
        for(int div = 100; div > 0; div /= 10) {
            int digit = inputNumber / div;
            userNumber.add(digit);
            inputNumber %= div;
        }
        return userNumber;
    }



}
