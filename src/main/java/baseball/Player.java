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

        for (int i = 0; i < playerStringNumber.length(); i++) {
            playerNumber.add(Integer.parseInt(String.valueOf(playerStringNumber.charAt(i))));
        }
    }
}


