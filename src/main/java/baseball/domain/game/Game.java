package baseball.domain.game;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.Message;

import java.util.List;

public class Game {

    Message message = new Message();
    User user;

    List<String> computerAnswer;
    boolean isFirstGame;

    public Game() {
        isFirstGame = true;
        startGame();
    }

    public void startGame() {
        user = new User();
        Computer computer = new Computer();
        computerAnswer = computer.computerAnswer;
        message.initialGameMessage();
        play();
    }

    public void play() {
        System.out.println(computerAnswer);
        Set set = new Set();
        boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            message.askPlayerInputAnswer();
            List<String> userAnswer = user.inputUserAnswer();
            set.startSet(computerAnswer, userAnswer);

            int ball = set.ball;
            int strike = set.strike;

            if (strike == 3) {
                isCorrectAnswer = true;
            }
            message.gameResultMessage(ball, strike);
        }

        if (replay()) {
            startGame();
        }
    }

    public boolean replay() {
        message.askPlayerReplayMessage();
        String replayAnswer = user.replay();
        if (replayAnswer.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}