package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.service.AnswerValidator;
import baseball.view.PlayingGameView;

import java.io.IOException;

public class GameController {
    PlayingGameView playingGame = new PlayingGameView();
    AnswerValidator answerValidator = new AnswerValidator();
    public void playGame(Computer computer) {
        Game game = new Game();
        do {
            playingGame.enterNumberPrint();
            User user = new User(playingGame.inputToQuestion());
            answerValidator.validate(user);
            game = game.checkBallStrike(computer.getComputerAnswer(), user.getUserAnswer());
            playingGame.gameResultPrint(game.getStrike(), game.getBall());
        } while (game.getStrike() != 3);
    }
}
