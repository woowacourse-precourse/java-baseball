package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInterface {
    public static List<Integer> getUsersAnswer() {
        try {
            List<Integer> answer = new ArrayList<>();

            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.length() != 3 || !validateUsersInput(input)) {
                throw new IllegalArgumentException();
            }

            for (char c : input.toCharArray()) {
                answer.add((int) c - '0');
            }
            return answer;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateUsersInput(String input) {
        Set<Character> inputCharSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputCharSet.add(c);
        }

        if (inputCharSet.size() != 3 || inputCharSet.stream().anyMatch(c -> c < '1' || c > '9')) {
            return false;
        }
        return true;
    }

    public static boolean resultOutput(int strike, int ball) {
        String result = "";
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            result += "낫싱";
        }
        System.out.println(result);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public static boolean exitOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            String input = Console.readLine();
            if (input.equals("1")) {
                return false;
            }
            if (input.equals("2")) {
                return true;
            }
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
