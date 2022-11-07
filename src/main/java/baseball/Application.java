package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static List<Integer> generateGameAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> initGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return generateGameAnswer();
    }
    public static void throwIllegalArgumentException() {
        throw new IllegalArgumentException("입력 값이 유효하지 않아 프로그램이 종료됩니다.");
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
