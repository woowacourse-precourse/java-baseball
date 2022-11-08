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
        // 세 개의 서로 다른 숫자가 아닌 경우 (인덴트 3개 이상으로, 수정해야 함)
        for (int inputIdx = 0; inputIdx < 2; inputIdx++) {
            for (int compareIdx = inputIdx + 1; compareIdx < 3; compareIdx++) {
                if (input.charAt(inputIdx) == input.charAt(compareIdx)) {
                    throw new IllegalArgumentException();
                }
            }
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
