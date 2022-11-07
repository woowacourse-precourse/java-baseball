package baseball;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static boolean validation(String input) {

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (!input.equals(input.chars().distinct().map(s -> s - 48).mapToObj(String::valueOf).collect(Collectors.joining()))) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static String generateRandomNumber() {
        boolean[] used = {false, false, false, false, false, false, false, false, false, false};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < 3) {
            int num = (int) (Math.random() * (9 - 1 + 1) + 1);
            if (!used[num]) {
                sb.append(num);
                used[num] = true;
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
