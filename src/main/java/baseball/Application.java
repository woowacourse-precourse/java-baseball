package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Integer> Answer_Numbers = new ArrayList<>();

    public static void Start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Generate_Answer();
        Input();
    }

    public static void Generate_Answer() {
        if (Answer_Numbers.size() != 0) {
            Answer_Numbers.clear();
        }
        while (Answer_Numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Answer_Numbers.contains(randomNumber)) {
                Answer_Numbers.add(randomNumber);
            }
        }
    }
    public static void main(String[] args) {

        // TODO: 프로그램 구현
    }
}
