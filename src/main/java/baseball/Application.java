package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    public static String generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        // 중복되지 않는 3개의 숫자를 고른다
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        StringBuilder sb = new StringBuilder();
        numbers.forEach(sb::append);

        return sb.toString();
    }

    public static String getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        // 3글자가 아닐 경우는 잘못된 값이다
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 서로 다른 3개의 숫자인지 검사할 용도의 Set
        Set<Character> characterSet = new TreeSet<>();

        // 입력된 문자가 숫자인지 검증한다
        for (int i = 0; i < userInput.length(); i++) {
            char currentChar = userInput.charAt(i);
            if (currentChar < '1' || currentChar > '9') {
                throw new IllegalArgumentException();
            }
            characterSet.add(currentChar);
        }

        // 중복된 숫자가 있는지 검사한다
        if (characterSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
    }
}
