package baseball.domain;

import baseball.util.Message;

import java.util.List;

public class Game {

    Message message = new Message();
    User user;
    Computer computer;
    List<String> computerAnswer;
    boolean isFirstGame;

    public Game() {
        isFirstGame = true;
        this.user = new User();
        this.computer = new Computer();
        message.initialGameMessage();
    }

    public void startGame() {
        computerAnswer = computer.getComputerAnswer();
        boolean isCorrectSet = false;
        while (!isCorrectSet) {
            isCorrectSet = startSet();
        }
        if (replay()) {
            startGame();
        }
    }

    private boolean startSet() {
        message.askPlayerInputAnswer();
        List<String> userAnswer = user.getUserAnswer();
        Set set = new Set(computerAnswer, userAnswer);
        int ball = set.ball;
        int strike = set.strike;

        message.gameResultMessage(ball, strike);
        return (strike == 3);
    }

    public boolean replay() {
        message.askPlayerReplayMessage();
        String replayAnswer = user.getUserReplayAnswer();
        return replayAnswer.equals("1");
    }
}