package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameLoop {
    private final String RESTART = "1";
    private final String END = "2";

    public void executeGame() {
        String answer = RESTART;
        while (isRestart(answer)) {
            List<Integer> nums = new ComputerNumGenerator().NUMS;
            Game game = new Game(nums);
            game.play();
            Messages.endOrRestart();
            answer = Console.readLine();
        }
    }

    public boolean isRestart(String answer) {
        if (answer.equals(RESTART)) {
            return true;
        }else if (answer.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
