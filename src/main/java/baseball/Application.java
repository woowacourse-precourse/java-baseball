package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 임의의 세자리 숫자를 생성하는 기능
    public static List<Integer> makeNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 유저의 숫자를 입력받는 기능
    private static List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userNumbers = Console.readLine();
        return userNumbers.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}