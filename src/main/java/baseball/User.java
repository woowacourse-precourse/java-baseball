package baseball;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    protected String input;
    protected int number;

    protected int game_state;

    ArrayList<Character> numberList = new ArrayList<>();

    public void inputNumber() {
        String input = readLine();

        checkNumberInteger(input);
        checkNumberLength(input);

        madeNumber(input);
        checkNumberDigit();

        this.input = input;
    }

    public void inputGameState() {
        String input = readLine();
        if (input.equals("1")) {
            this.game_state = 1;
        } else if (input.equals("2")) {
            this.game_state = 2;
        } else if (!input.equals("1") || !input.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
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

    public boolean checkNumber(Character number) {
        return numberList.contains(number);
    }

    public void addNumber(Character input) {
        numberList.add(input);
    }

    public void madeNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!checkNumber(input.charAt(i))) {
                addNumber(input.charAt(i));
            }
        }
    }

    public void checkNumberDigit() {
        if (numberList.size() != 3) {
            throw new IllegalArgumentException("입력한 수가 서로 다른 3자리의 수가 아닙니다.");
        }
    }

    public void setNumber() {
        this.number = Integer.valueOf(this.input);
    }

    public void madeAnswer() {
        inputNumber();
        setNumber();
    }

}