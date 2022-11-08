package baseball.service;

import baseball.domain.GameDomain;
import baseball.util.RandomNumberMaker;
import baseball.view.Respondent;

public class GameService {
    final int SUCCESS = 3;
    int size;
    GameDomain game;
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

    private void play() {}
}
