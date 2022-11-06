package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ReGame {
    private final String YES = "1";
    private final String NO = "2";
    private String number;

    public ReGame() {
    }

    public void inputNumber() {
        System.out.println(Message.ASK.get());
        number = Console.readLine();
        isValidNumber(number);
    }

    private void isValidNumber(String number) throws IllegalArgumentException {
        if (!(YES.equals(number) || NO.equals(number))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOk() {
        return number.equals(YES);
    }
}
