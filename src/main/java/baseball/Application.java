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

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
