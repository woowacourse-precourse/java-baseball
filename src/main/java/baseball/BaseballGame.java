package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {

    private List<Integer> userThreeDifferentNumber;
    Computer computer = new Computer();
    User user = new User();
    Hint hint;
    boolean result = true;

    public void gameStart(){
        computer.threeDifferntNumber = computer.getThreeDifferntNumber();
        do {
            hint = new Hint();
            user.ThreeDifferentNumber = user.getThreeDifferentNumber();
            result = hint.gameEnd(computer.threeDifferntNumber, user.ThreeDifferentNumber);
        } while (result);
        gameRestart();
    }

    public void gameRestart() {
        int restart = 0;
        String userInput;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userInput = Console.readLine();
        checkOneOrTwo(userInput);
        restart = userInput.charAt(0) - '0';

        if (restart == 1) {
            gameStart();
        }
    }

    public void checkOneOrTwo(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("1 or 2만 입력할 수 있습니다.");
        }
    }
}
