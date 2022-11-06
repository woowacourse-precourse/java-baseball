package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static ComputerNumber computerNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerSelectNumber();
    }

    private static void computerSelectNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        computerNumber = new ComputerNumber(computer.get(0), computer.get(1), computer.get(2));
        playerSelectNumber();
    }

    private static void playerSelectNumber() {

    }
}
