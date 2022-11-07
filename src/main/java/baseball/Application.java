package baseball;

import java.util.List;

public class Application {
    public static int BALL_INDEX = 0;
    public static int STRIKE_INDEX = 1;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static void startGame() {
        Game game = new Game();

        List<Integer> playerGuess;
        int ball;
        int strike;

        do {
            playerGuess = Player.guessAnswerOfGame();

            List<Integer> ballStrikeCnt = game.getBallStrikeCnt(playerGuess);
            ball = ballStrikeCnt.get(BALL_INDEX);
            strike = ballStrikeCnt.get(STRIKE_INDEX);

            System.out.println(Game.getResultOfPlayerGuess(ball, strike));
        } while (!Game.isAllStrike(strike));


    }

    static boolean isValidSelection(String selection){
        List<String> candidates = List.of("1", "2");
        return  candidates.contains(selection);
    }
}
