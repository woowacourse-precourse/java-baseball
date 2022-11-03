package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Computer {
    static List<Integer> numbers;

    private static boolean hasNumber(Integer number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }
}