package baseball.controller;

import baseball.service.UserService;

public class GameController {
    private final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GET_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
    private final String FINISHED_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! ";
    private final String END_GAME = "게임 종료";

    private UserService userService = new UserService();

    public void startGame() {
        userService.initGame();
    }

    public boolean runningGame() {
        String finishedValue = "3스트라이크";
        String checkResult = "";

        System.out.print(GET_NUMBER_MESSAGE);
        userService.inputBaseballNumber();

        checkResult = userService.getCheckResult();
        System.out.println(checkResult);

        if (checkResult.equals(finishedValue)) {
            System.out.print(FINISHED_MESSAGE);
            System.out.println(END_GAME);
            return false;
        }

        return true;
    }

    public String restartGame() {
        String returnValue;
        System.out.println(GET_RESTART_MESSAGE);
        userService.inputRestartNumber();

        System.out.println("get");
        System.out.println(userService.getRestartNumber());
        returnValue = userService.getRestartNumber();

        return returnValue;
    }

    public boolean checkGame() {
        String restartGameValue;

        if (!runningGame()) {
            restartGameValue = restartGame();

            if (restartGameValue.equals("1")) {
                startGame();
                return true;
            } else if (restartGameValue.equals("2")) {
                return false;
            }
        }
        return true;
    }
}
