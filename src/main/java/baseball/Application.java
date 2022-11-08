package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void baseballGame() {
        List<Integer> randomNumber;
        String restartNumber = "";

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            randomNumber = createRandomNumber();
            restartNumber = startGame();
        } while (!restartNumber.equals("2"));
    }

    public static String startGame() {
        // TODO: 숫자 입력받기
        // TODO: 입력한 수에 대한 힌트
        return "";
    }

    public static void main(String[] args) {
        baseballGame();
    }
}
