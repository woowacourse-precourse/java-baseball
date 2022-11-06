package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game.init();
    }
}
class Game {
    static final String INITGAME = "숫자 야구 게임을 시작합니다.";
    static void init() {
        System.out.println(INITGAME);
        List answer = makeThreeNums();
    }
    static List makeThreeNums() {
        List<Integer> threeNums = new ArrayList<>();
        while (threeNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeNums.contains(randomNumber)) {
                threeNums.add(randomNumber);
            }
        }
        return threeNums;
    }
}