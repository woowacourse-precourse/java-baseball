package baseball;

import java.util.Scanner;

public class ReGame {
    private String number;
    private final String YES = "1";
    private final String NO = "2";

    public ReGame() {
    }

    public void inputNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Message.ASK.get());
        number = sc.next();
        isValidNumber(number);
    }

    public void isValidNumber(String number) throws IllegalArgumentException{
        if (!(YES.equals(number) || NO.equals(number))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOk() {
        if (number.equals(YES)) {
            return true;
        }
        return false;
    }
}
