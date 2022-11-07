package baseball;

import baseball.Computer;
import baseball.Count;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작하겠습니다.");
        List<Integer> computer = new ArrayList<>();
        Computer ramdomNumber = new Computer();
        ramdomNumber.ramdomComputer(computer);
        String number = "";
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            number = Console.readLine();
            List<Integer> user = new ArrayList<>();
            for (int i = 0; i < number.length(); i++) {
                user.add((int) number.charAt(i) - 48);
            }
            if (user.size() != 3 || user.get(0) == user.get(1) || user.get(1) == user.get(2) || user.get(0) == user.get(2)){
                throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
            }
            Count count = new Count();
            int result = count.counter(computer, user);
            if (result == 0) {
                continue;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            number = Console.readLine();
            System.out.println(number);
            if (number.equals("2")) {
                break;
            } else if (number.equals("1")) {
                computer.clear();
                ramdomNumber.ramdomComputer(computer);
                continue;
            } else {
                throw new IllegalArgumentException("1 혹은 2만 입력해 주세요.");
            }

        }
    }
}
