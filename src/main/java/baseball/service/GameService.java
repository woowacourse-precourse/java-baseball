package baseball.service;

import baseball.domain.Game;
import baseball.utils.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    private Game game;
    private final int RETRY_OK = 1;
    private final int RETRY_NO = 2;

    public GameService() {
    }

    public void setGame(int digit, int startRange, int endRange) {
        game = new Game(digit, startRange, endRange);
    }

    public void startGame() throws IllegalArgumentException {
        Message.printStartGame();
        game.pickComputerNum();

        do {
            doTurn();
        } while (game.getStrike() != game.getDigit());

        Message.printEndGame(game.getDigit());
    }

    private void doTurn() throws IllegalArgumentException {
        game.initTurn();
        game.pickUserNum();
        countScore();
    }

    private void countScore() throws IllegalArgumentException {
        List<Integer> computerNum = game.getComputer().getComputerNum();
        List<Integer> userNum = game.getUser().getUserNum();
        for (int com = 0; com < computerNum.size(); com++) {
            compareNum(computerNum, userNum, com);
        }
        Message.printScore(game.getStrike(), game.getBall());
    }

    private void compareNum(List<Integer> computerNum, List<Integer> userNum, int com) {
        for (int user = 0; user < userNum.size(); user++) {
            if (computerNum.get(com) == userNum.get(user)) {
                compareIndex(com, user);
            }
        }
    }

    private void compareIndex(int com, int user) {
        if (com == user) {
            game.plusStrike();
        }
        if (com != user) {
            game.plusBall();
        }
    }

    public boolean isReplay() throws IllegalArgumentException {
        Message.printReplayGame(RETRY_OK, RETRY_NO);
        int userInput = Integer.parseInt(Console.readLine());
        if (userInput != RETRY_OK && userInput != RETRY_NO) {
            throw new IllegalArgumentException();
        }
        if (userInput == RETRY_OK) {
            return true;
        }
        return false;
    }


}
