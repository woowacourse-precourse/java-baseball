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

    public static String judgeResult(String key, String target) {
        int[] result = {0, 0};
        for (int i = 0; i < 3; i++) {
            compare(key, target, result, i);
        }
        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private static void compare(String key, String target, int[] result, int i) {
        for (int j = 0; j < 3; j++) {
            char tc = target.charAt(i);
            char kc = key.charAt(j);
            if (tc == kc && i == j) {
                result[0] += 1;
            } else if (tc == kc && i != j) {
                result[1] += 1;
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
