package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        PrintWindow printWindow = new PrintWindow();
        Computer computer = new Computer();
        int command = 1;

        while (command == 1) {
            Game game = new Game(printWindow, computer());
            game.gamePlay();
            command = Integer.parseInt(Console.readLine());
            Validator.isRestartGame(command);
        }
    }

    private static Computer computer() {
        return computer();
    }


}
