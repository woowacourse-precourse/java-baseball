package baseball;

import baseball.utils.ConsoleLog;
import baseball.utils.MakeRandom;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ConsoleLog.println("숫자 야구 게임을 시작합니다.");
        List<Integer> numbers = MakeRandom.numbers();
    }
}
