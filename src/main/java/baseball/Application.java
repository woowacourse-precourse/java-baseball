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

    public static void validateUserNumbers(String userNumbers) {
        if (userNumbers.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 입력된 문자열의 길이가 3이 아닙니다.");
        }

        // 서로 다른 3개의 숫자인지 검사할 용도의 Set
        Set<Character> characterSet = new TreeSet<>();

        // 입력된 문자가 숫자인지 검증한다
        for (int i = 0; i < userNumbers.length(); i++) {
            char currentChar = userNumbers.charAt(i);
            if (currentChar < '1' || currentChar > '9') {
                throw new IllegalArgumentException("잘못된 입력입니다. 1 ~ 9 범위 이외의 문자가 입력되었습니다.");
            }
            characterSet.add(currentChar);
        }

        // 중복된 숫자가 있는지 검사한다
        if (characterSet.size() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 중복된 숫자가 입력되었습니다.");
        }
    }

    public static String getResult(String answer, String userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            char a = userNumbers.charAt(i);
            if (answer.charAt(i) == a) {
                strike++;
            } else if (answer.indexOf(a) != -1) {
                ball++;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (ball != 0) {
            sb.append(String.format("%d볼 ", ball));
        }
        if (strike != 0) {
            sb.append(String.format("%d스트라이크", strike));
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        return sb.toString().trim();
    }

    public static boolean manageGame() {
        String answer = generateRandomNumbers();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumbers = Console.readLine();

            validateUserNumbers(userNumbers);

            String result = getResult(answer, userNumbers);

            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력해야합니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameContinued = true;
        while (isGameContinued) {
            isGameContinued = manageGame();
        }
    }
}
