package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        User user = new User();

        game.gameStart();

        while (doGame(game, user)) ;
    }

    static boolean doGame(Game game, User user) {
        List<Integer> answer = game.setComputersRandomAnswer();
        Judge judge = new Judge(answer);
        while (true) {
            List<Integer> userPredictedAnswer = user.getUserPredictedAnswer();
            List<Integer> ballStrikeCount = judge.judgeUserGuess(userPredictedAnswer);

            if (!game.getGameResultOfJudge(ballStrikeCount)) {
                continue;
            }
            if (game.isPlayingNewGame()) {
                return true;
            }
            return false;
        }
    }
}
