package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Controller {

    private final String START = "숫자 야구 게임을 시작합니다.";
    private final String BINGGO = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String END = "게임을 완전히 종료합니다.";

    Service service = new Service();

    public void startGame() {
        int strike = 0;
        System.out.println(START);
        List<Integer> answer = service.pick();
        while (strike < 3) {
            strike = service.stage(answer);
        }
        System.out.println(BINGGO);
        restart();
    }

    private void restart() throws IllegalArgumentException{
        System.out.println(RESTART);
        String input = Console.readLine();
        if (input.equals("1")) {
            startGame();
        }
        if (input.equals("2")) {
            System.out.println(END);
        }
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
