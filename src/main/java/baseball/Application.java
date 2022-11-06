package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumber = getComputerNumber();
        System.out.println("computerNumber = " + computerNumber.toString());

        while (true) {
            List<Integer> user = getUserNumber();

        }
    }

    private static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
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

    private static Map<String, Integer> getBallStrikeCount(List<Integer> user, List<Integer> computer) {
        Map<String, Integer> result = new HashMap<>();
        result.put("볼", 0);
        result.put("스트라이크", 0);

        for (int index = 0; index < user.size(); index++) {
            if (computer.contains(user.get(index)) && user.get(index) == computer.get(index)) {
                result.put("스트라이크", result.get("스트라이크") + 1);
            } else if (computer.contains(user.get(index))) {
                result.put("볼", result.get("볼") + 1);
            }
        }

        return result;
    }
}
