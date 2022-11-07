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

        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
