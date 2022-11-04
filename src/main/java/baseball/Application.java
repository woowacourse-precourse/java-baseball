package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = createComputerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        int gameFlag = 0; // gameFlag = 0: 처음, 1: 재시작, 2: 종료
        while (gameFlag != 2) {
            int strike = 0;
            int ball = 0;
            boolean correctFlag = false;
        }
    }

    private static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
