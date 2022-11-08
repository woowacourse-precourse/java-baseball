package baseball;

import baseball.domain.Ball;
import baseball.domain.BallGenerator;
import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.init();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String s = Console.readLine();
            List<Ball> balls = new ArrayList<>();
            try {
               balls = BallGenerator.getBalls(s);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
            String result = computer.getResult(balls);
            System.out.println(result);
            if ("3스트라이크".equals(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String a = Console.readLine();
                if ("2".equals(a)) break;
                computer.init();
            }
        }
    }
}
