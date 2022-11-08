package baseball;

import camp.nextstep.edu.missionutils.Console;
import util.Constants;
import util.Rule;
import util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Computer computer;
    private User user;

    Game() {
        computer = new Computer();
        user = new User();
    }

    public void printStart() {
        System.out.println(Constants.GAME_START);
    }

    public void startGame() {

        List<Integer> comNumbers = computer.getNumbers();

        boolean isStrikeOut = false;
        do {
            List<Integer> userNumbers = user.getNumbers();

            /*상대방(컴퓨터) 나 비교*/
            List<Integer> result = Rule.getResult(comNumbers, userNumbers);
            if (Rule.isStrikeOut(result)){
                isStrikeOut = true;
            }

            user.clearNumbers();

        }while (!isStrikeOut);
    }

    public boolean isFinishGame() {
        System.out.println(Constants.GAME_FINISH);
        return isRestartGame();
    }

    private boolean isRestartGame() {

        System.out.println(Constants.GAME_RESTART);
        String restartInput = Console.readLine();
        if (UserInput.isValidGameStateInput(restartInput)){
            if (Integer.parseInt(restartInput) == Constants.RESTART){

                return true;

            } else if (Integer.parseInt(restartInput) == Constants.END) {

                return false;
            }
        }else{
            throw new IllegalArgumentException(Constants.INPUT_WRONG);
        }

        return false;
    }
}
