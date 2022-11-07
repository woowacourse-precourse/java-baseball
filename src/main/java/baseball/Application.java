package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> randomNumList = makeRandomNum();
    }
    public static List<Integer> makeRandomNum() {
        List<Integer> randomNumList = new ArrayList<>();
        while(randomNumList.size() < 3) {
            int newRandomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(newRandomNum)) {
                randomNumList.add(newRandomNum);
            }
        }
        return randomNumList;
    }

}
