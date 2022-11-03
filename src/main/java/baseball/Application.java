package baseball;

import baseball.utils.GameNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<Integer> gameNumber = GameNumberGenerator.generate();

        System.out.println("숫자 야구게임을 시작합니다.");
        boolean proceeding = true;
        while (proceeding) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();

            String pattern = "[1-9]{3}";
            if (!inputNumber.matches(pattern)) {
                throw new IllegalArgumentException("서로 다른 3자리 자연수를 입력해야합니다.");
            }

            Set<Character> inputNumbers = new HashSet<>();
            for (int i = 0; i < inputNumber.length(); i++) {
                inputNumbers.add(inputNumber.charAt(i));
            }
            if (inputNumbers.size() < 3) {
                throw new IllegalArgumentException("서로 다른 3자리 자연수를 입력해야합니다.");
            }
        }
    }
}
