package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computerList = new ArrayList<>();

            computerPick(computerList);
    }

    // 컴퓨터가 숫자를 선택하는 메서드
    static void computerPick(List<Integer> computerList) {
        while (computerList.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(pickNumber)) {
                computerList.add(pickNumber);
            }
        }
    }

}
