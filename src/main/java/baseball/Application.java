package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String MESSAGE_COMMAND_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        boolean restart = true;

        do {
            Game game = new Game();
            game.play();
            restart = askRestart();
        } while (restart);
    }

    private static boolean askRestart() {
        System.out.println(MESSAGE_COMMAND_RESTART_OR_END);
        int restartInput = Character.getNumericValue(Console.readLine().charAt(0));

        if (restartInput == 1) {
            return true;
        } else {
            return false;
        }
    }
}
