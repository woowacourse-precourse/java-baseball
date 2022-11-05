package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static final int numLen = 3;
    private static List<Integer> computerNum;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }
    public static void startGame(){
        computerNum = getRandomNum();
    }

    public static List<Integer> getRandomNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < numLen) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
