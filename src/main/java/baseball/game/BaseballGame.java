package baseball.game;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {




    public static String getPlayerNumber() {
        String playerNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력하세요.");
        playerNumber = scanner.nextLine();

        return playerNumber;
    }

}
