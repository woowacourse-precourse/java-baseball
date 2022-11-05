package baseball.game;

import baseball.number.PlayerNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballGame {

    PlayerNumber playerNumber;

    void start() {
        try {
            playerNumber = new PlayerNumber(getPlayerNumber());
        } catch (IllegalArgumentException e){
            System.out.println("올바른 숫자를 입력하세요.");
        }
    }

    public String getPlayerNumber() {

        String playerNumber;

        System.out.print("숫자를 입력하세요 : ");
        playerNumber = Console.readLine();
        System.out.println(playerNumber);

        return playerNumber;
    }
}
