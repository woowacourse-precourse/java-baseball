package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();

        List<Integer> computer = game.makesDifferenceThreeNumber();

        String user = Console.readLine();

        List<Integer> strikeAndBall = game.findStrikeAndBall(user, computer);
    }
}
