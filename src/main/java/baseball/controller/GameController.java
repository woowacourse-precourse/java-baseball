package baseball.controller;

import baseball.domain.User;
import baseball.service.BaseballService;
import baseball.service.UserService;

public class GameController {
    private final String GET_NUMBER = "숫자를 입력해주세요 : ";
    private final String GET_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private BaseballService baseballService;
    private UserService userService;


    public void initGame() {
        baseballService = new BaseballService();
        baseballService.startGame();

        userService = new UserService(new User());
    }

    public void progressGame() {
        System.out.print(GET_NUMBER);

        userService.inputBaseballNumber();
        baseballService.progress(userService.getBaseballNumber());

        System.out.println(baseballService.getResult());
    }

    public boolean isWin() {
        if (baseballService.getResult().equals("3스트라이크")) {
            System.out.println(WIN);
            return true;
        }

        return false;
    }

    public boolean restart() {
        System.out.println(GET_RESTART);
        userService.inputRestartSelection();

        if (userService.getRestartSelection().equals("1")) {
            initGame();
            return true;
        }

        return false;
    }
}
