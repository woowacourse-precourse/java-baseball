package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {

    public static void playBaseballGame() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            List<Integer> computer = Service.getRandomNum();
            System.out.println(computer);

            Service.service(computer);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int checkNum = Integer.parseInt(Console.readLine());
            if(Boolean.TRUE.equals(Service.restartCheck(checkNum))) {
                break;
            }
        }
    }
}
