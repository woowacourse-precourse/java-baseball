package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static List<Integer> generateRandom3Numbers() {
        List<Integer> randomNums = new ArrayList<>();
        for (int repetition = 0; repetition < 3; repetition++) {
            randomNums.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNums;
    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void main(String[] args) {
        List<Integer> answer = generateRandom3Numbers();
        System.out.println(answer);
        startGame();

    }
}
