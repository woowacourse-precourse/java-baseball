package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    protected static boolean is_in_progress = true;

    public static void start() {
        List<Integer> random_number = new ArrayList<>();
        is_in_progress = true;
        create_random_number(random_number);

        while (is_in_progress) {
            List<Integer> value = get_answer();
            HashMap<String, Integer> score = get_score(value, random_number);

            if (score.getOrDefault("strike", -1) == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                is_in_progress = false;
            } else {
                int ball = score.getOrDefault("ball", -1);
                int strike = score.getOrDefault("strike", -1);
                String result = "";

                if (ball != -1) result += score.get("ball") + "볼 ";
                if (strike != -1) result += score.get("strike") + "스트라이크";
                if (strike + ball == -2) result = "낫싱";

                System.out.println(result);
            }
        }
    }

    public static HashMap<String, Integer> get_score(List<Integer> answer, List<Integer> random_number) {
        HashMap<String, Integer> score = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int number = answer.get(i);
            if (random_number.contains(number)) {
                if (Objects.equals(random_number.get(i), answer.get(i))) {
                    score.put("strike", score.getOrDefault("strike", 0) + 1);
                } else {
                    score.put("ball", score.getOrDefault("ball", 0) + 1);
                }
            }
        }
        return score;
    }

    public static void create_random_number(List<Integer> random_number) {
        while (random_number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!random_number.contains(randomNumber)) {
                random_number.add(randomNumber);
            }
        }
    }

    public static List<Integer> get_answer() {
        List<Integer> value = new ArrayList<>();
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String str = Console.readLine();
            String[] my_list = str.split("");
            for (String test : my_list) {
                int var = Integer.parseInt(test);
                if (!value.contains(var)) {
                    value.add(var);
                } else {
                    throw new Exception();
                }
            }
            if (value.size() != 3) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return value;
    }
}
