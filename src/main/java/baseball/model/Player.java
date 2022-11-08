package baseball.model;

import camp.nextstep.edu.missionutils.Console;


public class Player {
    public String inputNum() {
        String input = Console.readLine();
        isValidateNumber(input);
        isValidateSizeNumber(3, input);
        return input;
    }

    public String selectMenu() {
        String input = Console.readLine();
        isValidateNumber(input);
        isValidateMenuNumber(input);
        return input;
    }

    public void isValidateNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidateSizeNumber(int size, String input) {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidateMenuNumber(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}