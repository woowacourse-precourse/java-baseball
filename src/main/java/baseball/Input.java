package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Input {


    public Input() {
    }

    public static String input() {
        String inputNumber = Console.readLine();
        System.out.println(isValidNumber(inputNumber));
        return inputNumber;
    }

    public static boolean isValidNumber(String inputNumber) {

        if (!inputNumber.matches("[0-9]{3}")) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
