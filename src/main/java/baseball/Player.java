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

        while (playerNumber.size() < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumber.add(Integer.parseInt(Console.readLine()));
        }
    }
}

