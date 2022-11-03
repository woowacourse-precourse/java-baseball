package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> gameNumberList = pickGameNumber();
        System.out.println(gameNumberList);
    }

    public static List<Integer> pickGameNumber() {
        List<Integer> gameNumberList = new ArrayList<>();
        while (gameNumberList.size() != 3) {
            gameNumberList = checkNumber(gameNumberList);
        }
        return gameNumberList;
    }

    public static List<Integer> checkNumber(List<Integer> gameNumberList) {
        int num = Randoms.pickNumberInRange(0, 9);
        System.out.println(num);
        if (!gameNumberList.contains(num)) {
            gameNumberList.add(num);
        }
        System.out.println(gameNumberList);
        return gameNumberList;
    }
}
