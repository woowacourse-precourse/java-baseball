package baseball;

import baseball.UserNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final HintMessage hintMessage;
    private final ComputerNumber computerNumber;
    private final UserNumber userNumber;
    private List<Integer> com;
    private List<Integer> user;
    private static boolean isFinish;
    private static boolean restart;
    private final RestartGameException restartGameException;

    public Game() {
        hintMessage = new HintMessage();
        computerNumber = new ComputerNumber();
        userNumber = new UserNumber();
        com = new ArrayList<>();
        user = new ArrayList<>();
        isFinish = true;
        restart = true;
        restartGameException = new RestartGameException();
    }

    public boolean startGame() {
        computerNumber.makeRandomNumber();
        List<Integer> com = computerNumber.getComputerNumber();
        for (Integer integer : com) {
            System.out.print("computerValue = " + integer + " ");
        }
        System.out.println();
        do {
            userNumber.makeUserNumber();
            user = userNumber.getUserNumber();
            hintMessage.isFinish = hintMessage.checkPoint(user, com);
        } while (hintMessage.isFinish);
        restart = checkRestartGame();
        return restart;
    }

    public boolean checkRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputNumber = Integer.parseInt(Console.readLine());
        restart = true;
        if (restartGameException.hasRestartNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
//        if (inputNumber == 1) {
//            return true;
//        }
        if (inputNumber == 2) {
            restart = false;
        }
        return restart;
    }
}
