package baseball.service;

import baseball.message.GameMessage;
import baseball.message.InputMessage;
import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;
    Game game;
    User user = new User();
    GameMessage gameMessage = new GameMessage();

    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new Game(Computer.getComputerNumber(size, start, end));
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            gameMessage.inGameMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
        game.initBaseBall();
        user.setUserNumbers(getUserNumber());
        computeScore();
    }

    private int[] getUserNumber() throws IllegalArgumentException {
        InputMessage.startInputMessage();
        String input = Console.readLine();
        return user.userNumber(input, size);
    }

    private void computeScore() {
        for (int i = 0; i < size; i++) {
            compute(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }

    private void compute(int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        plusCount(index, temp);
    }

    private void plusCount(int index, int temp) {
        if (temp != index && temp != -1) {
            game.plusBallCount();
        }
        if (temp == index) {
            game.plusStrikeCount();
        }
    }
}