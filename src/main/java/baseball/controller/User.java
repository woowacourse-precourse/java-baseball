package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private static List<Integer> userNumber = getInput();
    private static Scanner scanner = new Scanner(System.in);

    private static List<Integer> getInput() {
        String input = Console.readLine();
        int inputNumber = strToInteger(input);
        return mappingToList(inputNumber);
    }

    private static int strToInteger(String input) {
        Integer num = Integer.valueOf(input);
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
