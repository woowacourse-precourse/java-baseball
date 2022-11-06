package baseball;

import baseball.Exception.PlayerInputException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GamePlayer {

    public static void playGame() {
        Game game = new Game();

        while (true) {
            String player_input = Console.readLine();
            List<String> player_number = List.of(player_input.split(""));
            validatePlayer_number(player_number);
        }
    }

    private static void validatePlayer_number(List<String> player_number) {
        final int NUMBER_LENGTH = 3;

        if (player_number.size() != NUMBER_LENGTH) {
            throw new PlayerInputException();
        }

        if (player_number.stream()
                .filter(GamePlayer::validateInputRange)
                .distinct()
                .count() != NUMBER_LENGTH) {
            throw new PlayerInputException();
        }
    }

    private static boolean validateInputRange(String num) {
        final int ZERO = 0;
        return Integer.parseInt(num) > ZERO;
    }

}
