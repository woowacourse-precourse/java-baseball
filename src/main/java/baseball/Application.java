package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        System.out.println(User.getInput());
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
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        List result;
        try {
            result = checkInput(input);
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
    static List checkInput(String input) throws Exception {
        List result = getInputFormat(input);
        checkInputLength(result);
        checkInputDuplicate(result);
        return result;
    }
    static void checkInputLength(List input) throws Exception {
        if (input.size() != 3) {
            throw new Exception();
        }
    }
    static void checkInputDuplicate(List input) throws Exception {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (Object num: input) {
            if (map.containsKey(num)) {
                throw new Exception();
            }
            map.put((Integer) num, true);
        }
    }
    static List<Integer> getInputFormat(String input) {
        String[] stringArr = input.split("");
        int [] intArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();
        List result = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        return result;
    }
}