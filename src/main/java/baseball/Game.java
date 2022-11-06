package baseball;

import baseball.domain.Computer;
import java.util.List;

public class Game {
    public static void start() {
        List<Integer> computerNumber = Computer.createNumbers();
        while (true) {
            List<Integer> userNumber = NumberScanner.getNumbers();
            String result = Referee.compare(computerNumber, userNumber);
            System.out.println(result);
            if (result.equals("3스트라이크")){
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
