package baseball;

import baseball.controller.GameController;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View.printText(View.Text.start.print);
        do {
            String computer = GameController.createComputerNumber();
            do{
                View.printText(View.Text.input.print);
            }while (GameController.gameStart(Console.readLine(), computer) != 3);
            View.printText(View.Text.stop.print);
            View.printText(View.Text.choice.print);
        }while (Console.readLine().equals("1"));
        System.out.println("게임 종료");
    }
}
