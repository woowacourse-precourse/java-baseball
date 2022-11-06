package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> user = getUserNumber();
            
        }
    }

    private static List<Integer> getUserNumber() {
        List<String> userNumber = Arrays.asList(Console.readLine().split(""));
        return userNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
