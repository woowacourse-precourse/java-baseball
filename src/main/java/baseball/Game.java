package baseball;

import baseball.UserNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int GAME_END = 2;
    private final HintMessage hintMessage;
    private final ComputerNumber computerNumber;
    private final UserNumber userNumber;
    private List<Integer> randomComputerNumber;
    private List<Integer> inputUserNumber;
    private boolean isFinish;
    private boolean isRestart;
    private final RestartGameException restartGameException;

    public Game() {
        hintMessage = new HintMessage();
        computerNumber = new ComputerNumber();
        userNumber = new UserNumber();
        randomComputerNumber = new ArrayList<>();
        inputUserNumber = new ArrayList<>();
        isFinish = true;
        isRestart = true;
        restartGameException = new RestartGameException();
    }

    public void startGame() {
        computerNumber.makeRandomNumber();
        randomComputerNumber = computerNumber.getComputerNumber();
        for (Integer integer : randomComputerNumber) {
            System.out.print("computerValue = " + integer + " ");
        }
        System.out.println();
        do {
            userNumber.makeUserNumber();
            inputUserNumber = userNumber.getUserNumber();
            isFinish = hintMessage.checkPoint(inputUserNumber, randomComputerNumber);
        } while (isFinish);
        isRestart = checkRestartGame();
    }

    public boolean checkRestartGame() {
        System.out.println(SystemMessage.GAME_CONTINUE_MESSAGE);
        int inputNumber = Integer.parseInt(Console.readLine());
        if (restartGameException.isRestartNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
//        if (inputNumber == 1) {
//            return true;
//        }
        if (inputNumber == GAME_END) {
            isRestart = false;
        }
        return isRestart;
    }

    public boolean c() {
        return isRestart;
    }
}
