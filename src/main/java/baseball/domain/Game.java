package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private Computer computer = new Computer();

    public void start() {
        init();
        while (true) {
            String s = input();
            List<Ball> balls = getBalls(s);
            String result = getResult(balls);
            System.out.println(result);
            if (end(result)) {
                break;
            }
        }
    }

    private List<Ball> getBalls(String s) {
        try {
            List<Ball> balls = BallGenerator.getBalls(s);
            return balls;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private String input() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private String getResult(List<Ball> balls) {
        return computer.getResult(balls);
    }

    private void init() {
        computer.init();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private boolean end(String result) {
        if (!"3스트라이크" .equals(result)) {
            return false;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String a = Console.readLine();
        if ("2" .equals(a)) {
            return true;
        }
        computer.init();
        return false;
    }
}
