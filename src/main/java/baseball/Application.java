package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumber = getComputerNumber();

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

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
