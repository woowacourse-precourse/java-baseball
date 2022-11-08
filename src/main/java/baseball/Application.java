package baseball;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        gameView.gameStartMessage();
        int status = 1;
        do {
            List<Integer> computerNumber = Computer.setRandomNumber();
            Game.playGame(computerNumber);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status = Integer.parseInt(Console.readLine());

        } while (status == 1);

        gameView.exitMessage(status);
    }
}
