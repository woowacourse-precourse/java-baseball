package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerList = new ArrayList<>();
        String inputString = startUserInput();
        computerPick(computerList);
    }

    // 컴퓨터가 숫자를 선택하는 메서드
    static void computerPick(List<Integer> computerList) {
        while (computerList.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(pickNumber)) {
                computerList.add(pickNumber);
            }
        }
    }

    // 게임을 시작하고 사용자의 입력을 받는 메서드
    static String startUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return Console.readLine();
    }

    // 게임이 종료되고 사용자의 재시작 입력을 받는 메서드
    static String restartUserInput() {
        return Console.readLine();
    }

}
