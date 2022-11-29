package baseball.service;

import baseball.util.Message;

import java.util.List;
import java.util.Map;

public class Game {

    Message message = new Message();
    Set set;
    Computer computer;
    List<String> computerAnswer;

    public Game() {
        this.computer = new Computer();
        message.initialGameMessage();
    }

    public void startGame() {
        computerAnswer = computer.generateComputerAnswer();
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
        set = new Set(computerAnswer);
        set.inputUserAnswer();
        Map<String, Integer> setResult = set.calculate();

        int ball = setResult.get(ResultKeys.BALL.getKey());
        int strike = setResult.get(ResultKeys.STRIKE.getKey());

        message.gameResultMessage(ball, strike);
        return strike == GameSetting.GAME_END.getAttribute();
    }

    public boolean replay() {
        message.askPlayerReplayMessage();
        return set.inputReplayAnswer();
    }
}