package baseball.controller;

import baseball.service.UserService;

public class GameController {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GET_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
    private final String FINISHED_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private UserService userService = new UserService();

    public void startGame() {
        System.out.println(START_MESSAGE);
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
            System.out.println(FINISHED_MESSAGE);
            return false;
        }

        return true;
    }

    public String restartGame() {
        System.out.println(GET_RESTART_MESSAGE);
        userService.inputRestartNumber();
        return userService.getRestartNumber();
    }
}
