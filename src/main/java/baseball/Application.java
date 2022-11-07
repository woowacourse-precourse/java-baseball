package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Game.init();
    }
}

class Game {
    static final String INITGAME = "숫자 야구 게임을 시작합니다.";
    static final String ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    static void init() {
        System.out.println(INITGAME);
        Hint hint = new Hint(makeThreeNums());
        String result;
        do {
            result = hint.get(User.getGameInput());
            System.out.println(result);
        } while (!result.equals("3스트라이크"));
        end();
    }

    static List<Integer> makeThreeNums() {
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
        User.getRestartInput();
    }
}

class User {
    final static String PROMPT = "숫자를 입력해주세요 : ";
    static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    static List getGameInput() {
        System.out.print(PROMPT);
        String input = Console.readLine();
        List result;
        try {
            result = checkGameInput(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    static void getRestartInput() {
        System.out.println(RESTART);
        String input = Console.readLine();
        if (input.equals("1")) {
            Game.init();
        } else if (input.equals("2")) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static List checkGameInput(String input) throws Exception {
        List result = getGameInputFormat(input);
        checkGameInputLength(result);
        checkGameInputDuplicate(result);
        return result;
    }

    static void checkGameInputLength(List<Integer> input) throws Exception {
        if (input.size() != 3) {
            throw new Exception();
        }
    }

    static void checkGameInputDuplicate(List<Integer> input) throws Exception {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (Integer num : input) {
            if (map.containsKey(num)) {
                throw new Exception();
            }
            map.put(num, true);
        }
    }

    static List<Integer> getGameInputFormat(String input) {
        String[] stringArr = input.split("");
        int[] intArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();
        List result = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        return result;
    }
}

class Hint {
    final static String BALL = "볼";
    final static String STRIKE = "스트라이크";
    final static String NOTHING = "낫싱";
    final List<Integer> answer;

    Hint(List answer) {
        this.answer = answer;
    }

    String get(List<Integer> input) {
        String result = "";
        int ball = countBall(input);
        int strike = countStrike(input);
        if (ball + strike == 0) {
            return NOTHING;
        }
        if (ball > 0) {
            result += ball + BALL;
        }
        result += " ";
        if (strike > 0) {
            result += strike + STRIKE;
        }
        return result.trim();
    }

    int countStrike(List<Integer> input) {
        int result = 0;
        for (Integer num : input) {
            if (answer.contains(num) && answer.indexOf(num) == input.indexOf(num)) {
                result += 1;
            }
        }
        return result;
    }

    int countBall(List<Integer> input) {
        int result = 0;
        for (Integer num : input) {
            if (answer.contains(num) && answer.indexOf(num) != input.indexOf(num)) {
                result += 1;
            }
        }
        return result;
    }
}