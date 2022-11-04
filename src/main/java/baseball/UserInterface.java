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
            if (!validateUsersInput(input)) {
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
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (strike != 0) {
            if (ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else {
                System.out.println(strike + "스트라이크");
            }
        } else {
            if (ball != 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }
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
