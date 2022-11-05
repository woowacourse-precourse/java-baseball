package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    /** 컴퓨터가 생성하는 1-9 사이의 서로 다른 임의의 숫자로 이루어진 3개의 수로 이루어진 리스트를 생성 */
    public static List<Integer> getThreeRandomNumbersList() {
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        return computerNumberList;
    }
}
