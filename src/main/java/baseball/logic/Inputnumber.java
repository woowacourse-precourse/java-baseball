package baseball.logic;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Inputnumber {
    public inputException exception;
    public List<Integer> playerInput = new ArrayList<>();

    public List<Integer> getNum() {
        List<Integer> convertNum = converttoInt();
        if (exception.checkException(convertNum)) {
            throw new IllegalArgumentException();
        }
        playerInput = convertNum;
        return playerInput;
    }

    public List<Integer> converttoInt() {
        System.out.println("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        List<Integer> Numlist = new ArrayList<>();

        for (int i = 0; i < playerInput.length(); i++) {
            Numlist.add(playerInput.charAt(i) - '0');
        }
        return Numlist;
    }
}
