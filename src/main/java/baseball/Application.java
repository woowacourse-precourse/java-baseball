package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        PrintWindow printWindow = new PrintWindow();
        int command = 1;

        while (command == 1) {
            Game game = new Game(printWindow);
            game.gamePlay();
            command = Integer.parseInt(Console.readLine());
        }
    }
}
