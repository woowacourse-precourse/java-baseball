package baseball.game;

import baseball.number.PlayerNumber;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    PlayerNumber playerNumber;

    void start() {
        try {
            playerNumber = new PlayerNumber(setPlayerNumber());
        } catch (IllegalArgumentException e){
            System.out.println("올바른 숫자를 입력하세요.");
        }
    }

    public String setPlayerNumber() {

        String playerNumber;

        System.out.print("숫자를 입력하세요 : ");
        playerNumber = Console.readLine();

        return playerNumber;
    }
}
