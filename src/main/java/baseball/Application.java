package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/** 기능 목록
 * 1. 컴퓨터가 1 ~ 9 까지 서로 다른 임의의 수 3개를 선택
 *   1-1. 요구사항에 나와있는 라이브러리를 사용하여 구현한다.
**/

public class Application {
    public static void main(String[] args) {

        List<Integer> result = creatRandomNumber();
    }

    private static List<Integer> creatRandomNumber() {
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
