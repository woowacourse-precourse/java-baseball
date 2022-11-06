package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameLoop {

    public void executeGame() {
        String answer = Constants.RESTART;
        while (isRestart(answer)) {
            List<Integer> nums = new ComputerNumGenerator().NUMS;
            Game game = new Game(nums);
            game.play();
            Messages.endOrRestart();
            answer = Console.readLine();
        }
    }

    public boolean isRestart(String answer) {
        if (answer.equals(Constants.RESTART)) {
            return true;
        } else if (answer.equals(Constants.END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
