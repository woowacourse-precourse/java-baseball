package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumber;

    public Player() {
        playerNumber = new ArrayList<>();
    }

    public static void inputErrorCheck(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }

    }
    public void makePlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        inputErrorCheck(input);
        playerNumber.clear();

        int playerIdx = 0;
        while(playerNumber.size() < 3) {
            char inputNumber = input.charAt(playerIdx);
            int inputNumberToInt = inputNumber - '0';
            playerNumber.add(inputNumberToInt);
            playerIdx++;
        }
    }

    public List<Integer> getPlayerNumber() {
        List<Integer> playerNum = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            playerNum.add(this.playerNumber.get(i));
        }
        return playerNum;
    }
}
