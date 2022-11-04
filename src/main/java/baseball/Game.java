package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_GAME_CONDITION = "3스트라이크\n"
            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_CONDITION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_LENGTH_EXCEPTION = "세자리 수를 입력해주세요";
    private static final String INPUT_OTHER_NUMBER_EXCEPTION = "각각 다른 수를 입력해주세요";
    private static final String INPUT_RESTART_EXCEPTION = "1 또는 2를 입력해주세요";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRKIE = "스트라이크";

    public void start() {
        System.out.println(START_GAME);

        List<Integer> computer = makeAnswer();

        String result = "";
        while (!result.equals(END_GAME_CONDITION)) {
            System.out.print(INPUT_NUMBER);
            String input = Console.readLine();
            List<Integer> user = new ArrayList<>();
            try {
                if (input.length() != 3) {
                    throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION);
                }
                for (String number : input.split("")) {
                    int ball = Integer.parseInt(number);
                    if (user.contains(ball)) {
                        throw new IllegalArgumentException(INPUT_OTHER_NUMBER_EXCEPTION);
                    }
                    addBall(user, ball);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }

            int strike = 0;
            int ball = 0;
            for (int i = 0; i < user.size(); i++) {
                if (computer.contains(user.get(i)) && Objects.equals(computer.get(i), user.get(i))) {
                    strike++;
                }
                if (computer.contains(user.get(i)) && !Objects.equals(computer.get(i), user.get(i))) {
                    ball++;
                }
            }

            if (ball == 0 && strike == 0) {
                result = NOTHING;
                System.out.println(result);
            }
            if (strike == 0 && ball != 0) {
                result = ball + BALL;
                System.out.println(result);
            } else if (ball == 0 && strike != 0) {
                result = strike + STRKIE;
                if (strike == 3) {
                    result = END_GAME_CONDITION;
                }
                System.out.println(result);
            } else {
                System.out.println(ball + BALL + " " + strike + STRKIE);
            }
        }

        System.out.println(RESTART_CONDITION);
        String input = Console.readLine();
        if (input.equals("1")) {
            start();
        } else if (!input.equals("2")) {
            throw new IllegalArgumentException(INPUT_RESTART_EXCEPTION);
        }
    }

    private static List<Integer> makeAnswer() {
        List<Integer> list = new ArrayList<>();
        while (list.size() != 3) {
            addBall(list, Randoms.pickNumberInRange(1, 9));
        }
        return list;
    }

    private static void addBall(List<Integer> list, int random) {
        if (!list.contains(random)) {
            list.add(random);
        }
    }
}
