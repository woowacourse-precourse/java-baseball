package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        System.out.println(START_SENTENCE);
        List<Integer> answer = generateRandomNumber();
    }

    public static List<Integer> generateRandomNumber() {
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