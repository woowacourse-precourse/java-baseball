package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private List<Integer> number = new ArrayList<Integer>();

    public void input() {
        System.out.print("숫자를 입력해주세요 : ");

        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();

        if (check_input(inputString) == false) {
            throw new IllegalArgumentException();
        }

        for (String str : inputString.split("")) {
            this.number.add(Integer.parseInt(str));
        }
    }

    public boolean check_input(String input) {

        // 서로 다른 세 자리 수인지 확인
        if (input.length() != 3) {
            return false;
        }

        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            return false;
        }

        for (int i=0; i<input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> getNumber() {
        return number;
    }

}
