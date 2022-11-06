package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 컴퓨터가 3자리 숫자의 리스트 생성
        List<Integer> computerNumber = GenerateRandomNumber();

    }

    private static List<Integer> GenerateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
