package baseball;

import baseball.game.Service;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            List<Integer> computer = getRandomNum();
            System.out.println(computer);

            Service.service(computer);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int checkNum = Integer.parseInt(Console.readLine());
            if(Boolean.TRUE.equals(restartCheck(checkNum))) {
                break;
            }
        }
    }
    public static List<Integer> getRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Boolean restartCheck(int num) {

        if(num == 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        else throw new IllegalArgumentException();
    }
}
