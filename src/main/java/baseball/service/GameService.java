package baseball.service;

import baseball.domain.GameDomain;
import baseball.domain.UserDomain;
import baseball.util.RandomNumberMaker;
import baseball.util.UserNumberParser;
import baseball.view.Requester;
import baseball.view.Respondent;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    final int SUCCESS = 3;
    int size;
    GameDomain game;
    UserDomain user = new UserDomain();
    UserNumberParser parse = new UserNumberParser();
    Respondent respond = new Respondent();

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new GameDomain(RandomNumberMaker.getRandomNumbers(size, start, end));
    }

    public void playGame() {
        int strike = 0;
        while (strike != SUCCESS) {
            play();
            respond.respondScoreResult(game.getBallScore(), game.getStrikeScore());
            strike = game.getStrikeScore();
        }
    }

    private void play() {
        game.initScore();
        user.setUserNumbers(getUserInput());
    }

    private int[] getUserInput() throws IllegalArgumentException {
        Requester.requestInput();
        String input = Console.readLine();
        return parse.parseUserNumber(input, size);
    }
}
