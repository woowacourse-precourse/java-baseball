package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Controller {

    Service service = new Service();

    public void startGame() {
        int strike = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = service.pick();
        while (strike < 3) {
            strike = service.stage(answer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restart();
    }

    private void restart() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            startGame();
        }
        if (input.equals("2")) {
            System.out.println("게임을 완전히 종료합니다.");
        }
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
