package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    public Controller() {
    }

    public void start() {
        Computer computer = new Computer();
        Game game = new Game(computer);
        String state = "1";
        while (Integer.parseInt(state) != 2) {
            game.init();
            game.start();
            printRestartMessage();
            state = readLine();
            isValidateInput(state);
        }
    }

    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void isValidateInput(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("Input is wrong.");
        }
    }
}
