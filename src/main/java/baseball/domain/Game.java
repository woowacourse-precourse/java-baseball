package baseball.domain;

import baseball.util.Message;

import java.util.List;

public class Game {

    Message message;
    User user;
    Computer computer;
    List<String> computerAnswer;
    boolean isFirstGame;

    public Game() {
        isFirstGame = true;
        this.user = new User();
        this.computer = new Computer();
        this.message = new Message();
    }

    public void startGame() {
        computerAnswer = computer.getComputerAnswer();
        message.initialGameMessage();
        play();
    }

    public void play() {

        boolean isCorrectSet = false;
        while (!isCorrectSet) {
            isCorrectSet = playSet();
        }

        if (replay()) {
            startGame();
        }
    }

    private boolean playSet() {
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