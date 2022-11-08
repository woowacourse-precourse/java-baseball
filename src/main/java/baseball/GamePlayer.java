package baseball;

import baseball.Exception.EndOfGameException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePlayer {

    public static void playGame() {
        Game game = new Game();
        try {
            while (true) {
                List<Integer> player_number = getPlayerInput();

                validatePlayer_number(player_number);

                playOneTurn(game, player_number);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> getPlayerInput() {
        return Stream.of(Console.readLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void playOneTurn(Game game, List<Integer> player_number) {
        final int strike = game.getCountOfStrike(player_number);
        final int ball = game.getCountOfBall(player_number, strike);

        System.out.println(strike + "스트라이크 , " + ball + "볼");

        if(strike == 3){
            throw new EndOfGameException();
        }
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
