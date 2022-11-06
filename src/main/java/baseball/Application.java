package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        Game.init();
    }
}
class Game {
    static final String INITGAME = "숫자 야구 게임을 시작합니다.";
    static final String ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
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
    static void end() {
        System.out.println(ENDGAME);
        System.out.println(RESTART);
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        if (input.equals("1")) {
            init();
        } else if (input.equals("2")) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
class User {
    static List getInput() {
        String[] stringArr = camp.nextstep.edu.missionutils.Console.readLine().split("");
        int[] intArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();
        List result = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        return result;
    }
}