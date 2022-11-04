package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() != 3) {
            addBall(computer, Randoms.pickNumberInRange(1, 9));
        }

        String result = "";
        while (!result.equals("3스트라이크")) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> user = new ArrayList<>();
            try {
                if (input.length() != 3) {
                    throw new IllegalArgumentException("세자리 수를 입력해주세요");
                }
                for (String number : input.split("")) {
                    int ball = Integer.parseInt(number);
                    if (user.contains(ball)) {
                        throw new IllegalArgumentException("각각 다른 수를 입력해주세요");
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
                result = "낫싱";
                System.out.println(result);
            }
            if (strike == 0 && ball != 0) {
                result = ball + "볼";
                System.out.println(result);
            } else if (ball == 0 && strike != 0) {
                result = strike + "스트라이크";
                System.out.println(result);
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            start();
        } else if (!input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }
    }

    private static void addBall(List<Integer> list, int random) {
        if (!list.contains(random)) {
            list.add(random);
        }
    }
}
