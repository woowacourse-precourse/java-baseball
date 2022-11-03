package baseball;

import baseball.controller.GameController;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int answer = 3;
        // TODO: 프로그램 구현
        View.printText(View.Text.start.print);
        do {
            String computer = GameController.createComputerNumber();
            do {
                View.printText(View.Text.input.print);
            } while (GameController.gameStart(Console.readLine(), computer) != answer);
            View.printText(View.Text.stop.print);
            View.printText(View.Text.choice.print);
        } while (Console.readLine().equals("1"));
    }
}
