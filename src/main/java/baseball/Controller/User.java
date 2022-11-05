package baseball.Controller;

import baseball.model.Baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private static Scanner scanner = new Scanner(System.in);

    public Baseball getInput(){
        String input = Console.readLine();
        int inputNumber = strToInteger(input);
        List<Integer> userNumber = mappingToList(inputNumber);
        return new Baseball(userNumber);
    }

    public static Integer strToInteger(String input){
        Integer num = Integer.valueOf(input);
        return num;
    }

    public static List<Integer> mappingToList(int inputNumber){
        List<Integer> userNumber = new ArrayList<>();
        for(int div = 100; div > 0; div /= 10){
            int digit = inputNumber / div;
            userNumber.add(digit);
            inputNumber %= div;
        }
        return userNumber;
    }

}
