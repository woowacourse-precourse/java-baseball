package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}
