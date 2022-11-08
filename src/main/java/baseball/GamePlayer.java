package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePlayer {

    public static void playGame() {
        Game game = new Game();

        while (true) {
            List<Integer> player_number = getPlayerInput();

            validatePlayer_number(player_number);

            boolean is_out = playOneTurn(game, player_number);

            if (is_out) return;
        }

    }

    private static List<Integer> getPlayerInput() {
        final String MESSAGE = "숫자를 입력해주세요 : ";

        String player_input = ConsoleInput.inputWithMessage(MESSAGE);

        return Stream.of(player_input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean playOneTurn(Game game, List<Integer> player_number) {
        final int STRIKE_OUT = 3;
        final int NOTHING = 0;

        final int strike = game.getCountOfStrike(player_number);
        final int ball = game.getCountOfBall(player_number, strike);

        if (strike == STRIKE_OUT) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strike == NOTHING && ball == NOTHING) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }

    private static void validatePlayer_number(List<Integer> player_number) {
        final int NUMBER_LENGTH = 3;

        if (player_number.size() != NUMBER_LENGTH
                || getDistinctPlayerNumLength(player_number) != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static long getDistinctPlayerNumLength(List<Integer> player_number) {
        return player_number.stream()
                .filter(GamePlayer::validateInputRange)
                .distinct()
                .count();
    }

    private static boolean validateInputRange(int num) {
        final int ZERO = 0;
        return num > ZERO;
    }

}
