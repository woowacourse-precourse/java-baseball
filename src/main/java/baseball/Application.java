package baseball;

import baseball.controller.Controller;
import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        View view = new View();
        Game game = new Game();
        Controller controller = new Controller(computer, user, game, view);

        while (controller.getGameState() == Game.GameState.RUNNING) {
            String userInput = Console.readLine();
            controller.setUserNumeralList(controller.toList(userInput));
            controller.judge();


        }


    }
}
