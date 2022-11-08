package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseballGameInputFilter {

    private final Scanner scanner = new Scanner(System.in);

    private int numberLength = 3;

    public boolean isValidLength(String input) {
        return input.length() == this.numberLength;
    }

    public boolean isNumeric(String input) {
        return input.matches("[1-9]+");
    }

    public boolean isNotDuplicated(String input) {
        boolean[] isNumberOfIndex = new boolean[10];

        for (char ch : input.toCharArray()){
            if (isNumberOfIndex[Character.getNumericValue(ch)]) return false;
            isNumberOfIndex[Character.getNumericValue(ch)] = true;
        }
        return true;
    }

    public String readNumbers(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = scanner.nextLine();

        if (!this.isValidLength(input)) {
            throw new IllegalArgumentException();
        }
        if (!this.isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        if (!this.isNotDuplicated(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public boolean readReparticipation() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String flag = scanner.nextLine();

        if (flag == "1") return true;
        else if (flag == "2") return false;

        throw new IllegalArgumentException();
    }

}
