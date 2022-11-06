package baseball;

import baseball.controller.GameController;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int answer = 3;
        String user;
        // TODO: 프로그램 구현
        View.printText(Text.start.getPrint());
        do {
            String computer = GameController.createComputerNumber();
            do {
                View.printText(Text.input.getPrint());
                user = Console.readLine();
            } while (GameController.gameStart(user, computer) != answer);
            View.printText(Text.stop.getPrint());
            View.printText(Text.choice.getPrint());
        } while (Console.readLine().equals("1"));
    }
}
