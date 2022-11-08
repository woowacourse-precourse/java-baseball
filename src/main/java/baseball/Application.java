package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    // 게임 시작
    public static void gameStart() {
        int[] computerNumbers = getRandomNumbers();
        int[] userNumbers = getUserNumbers();
        compareNumbers(computerNumbers, userNumbers);
    }

    // 랜덤한 숫자 3개 고르기
    public static int[] getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        return computer.stream().mapToInt(i -> i).toArray();
    }
}
