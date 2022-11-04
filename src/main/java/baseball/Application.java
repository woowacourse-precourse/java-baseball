package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> getNumberOfComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {

        // 1. 상대방(컴퓨터)의 숫자를 설정한다.
        List<Integer> computer = new ArrayList<>();
        computer = getNumberOfComputer(computer);
        System.out.println(computer); // 테스트 출력
    }


}
