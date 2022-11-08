package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {
    static List<Integer> target;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    static void setTarget() {
        Set<Integer> randNumSet = new LinkedHashSet<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (randNumSet.size() < 3) {
            int pickNum = Randoms.pickNumberInRange(1, 9);
            if (!randNumSet.contains(pickNum)) {
                randNumSet.add(pickNum);
            }
        }
        ArrayList<Integer> target = new ArrayList<>(randNumSet);
    }
}
