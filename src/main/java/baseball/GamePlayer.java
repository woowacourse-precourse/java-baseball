package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GamePlayer {

    public static void playGame() {
        Game game = new Game();

        while (true) {
            String player_input = Console.readLine();
            List<String> player_number = List.of(player_input.split(""));
        }
    }

}
