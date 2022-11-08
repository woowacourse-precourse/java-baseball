package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.view.PlayingGameView;

public class GameController {
    PlayingGameView playingGameView = new PlayingGameView();
    public void playGame(Computer computer) {
        Game game;
        do {
            playingGameView.enterNumberPrint();
            User user = new User(playingGameView.inputToQuestion());
            game = new Game();
            game.checkBall(computer.getComputerAnswer(), user.getUserAnswer());
            playingGameView.gameResultPrint(game.getStrike(), game.getBall());
        } while (game.ThreeStrikeCheck());
    }
}
