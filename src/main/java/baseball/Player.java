package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String inputMessage = "숫자를 입력해주세요 : ";
    private String input;

    public void getPlayerInput() {
        System.out.print(inputMessage);
        String input = Console.readLine();

        inputValidationCheck(input);
        this.input = input;

    public void inputValidationCheck(String input) {
        //IllegalArgumentException 발생 처리
        //입력이 없는 경우
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력을 해야합니다");
        }
        //3자리가 아닌 경우
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리만 입력 가능합니다");
        }

        //숫자 입력이 아닌 경우
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
    }
    }

    public String getInput() {
        return input;
    }
}
