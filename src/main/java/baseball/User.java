package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class User {
    private String number;

    public void inputNumber() {
        Computer computer = new Computer();
        computer.startGame();
        number = Console.readLine();
    }

    public List<Integer> createUserNumber() {
       inputNumber();
       String[] splitNumber = number.split("");
       List<Integer> userNumbers = new ArrayList<>();
       for (String number : splitNumber) {
           int numberToInt = Integer.parseInt(number);
           userNumbers.add(numberToInt);
       }
       return userNumbers;
    }
}
