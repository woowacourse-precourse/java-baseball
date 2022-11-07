package baseball;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    protected String input;
    protected int number;

    ArrayList<Character> check = new ArrayList<>();

    public void inputNumber() {
        String input = readLine();

        checkNumberInteger(input);
        checkNumberLength(input);
        checkNumberDigit(input);

        this.input = input;
    }

    public void checkNumberInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException("입력에 숫자가 아닌 문자가 포함되어 있습니다.");
            }
        }
    }

    public void checkNumberLength(String input) {

        if (input.length() == 0) {
            throw new IllegalArgumentException("입력한 수가 없습니다.");
        } else if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 수가 세 자리의 수가 아닙니다.");
        }
    }

    public void addNumber(Character input) {
        check.add(input);
    }

    public void checkNumberDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!check.contains(input.charAt(i))) {
                addNumber(input.charAt(i));
            }
        }

        if (check.size() != 3) {
            throw new IllegalArgumentException("입력한 수가 서로 다른 3자리의 수가 아닙니다.");
        }
    }

    public void setNumber() {
        inputNumber();
        this.number = Integer.valueOf(this.input);
    }

    public void resetNumber() {
        check.clear();
    }
}