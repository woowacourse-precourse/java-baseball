package baseball.service;

import baseball.domain.Game;
import baseball.utils.RandomNumber;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Service {
    Game game;

    public void setGame() {
        List<Integer> randomNumberList = RandomNumber.generateUnduplicatedThreeNumbers();
        this.game = new Game(randomNumberList);
    }

    public void startGame() {
        SystemMessage.printGameStart();
        RequestInput.requestAnswer();
        String userInput = Console.readLine();
    }
}
