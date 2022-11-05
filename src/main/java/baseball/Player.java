package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Integer> playerNumber;

    public Player(List<Integer> player) {
        this.playerNumber = player;
    }

    public void player3NumberInput() {

        System.out.print("숫자를 입력해주세요 : ");
        String playerStringNumber = Console.readLine();

        if (!(numberCheck(playerStringNumber) && isNumeric(playerStringNumber))) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        for (int i = 0; i < playerStringNumber.length(); i++) {
            playerNumber.add(Integer.parseInt(String.valueOf(playerStringNumber.charAt(i))));
        }
    }

    public static boolean isNumeric(String playerStringNumber) {

        return playerStringNumber.chars().allMatch(Character::isDigit);
    }

    public static boolean numberCheck(String playerStringNumber) {

        return false;
    }
}


