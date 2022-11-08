package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    // 세자리 숫자가 맞는지 검증하는 기능
    public static void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해 주세요.");
        }
    }

    // 중복된 숫자가 포함되어 있는지 검증하는 기능
    public static void checkNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 임의의 수 3개를 선택해 주세요");
        }
    }

    // 1~9 사이 숫자인지 검증하는 기능
    public static void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력해 주세요.");
            }
        }
    }

    // 숫자야구에 적합한 수가 맞는지 검증하는 기능
    public static void checkRightNumber(List<Integer> numbers) {
        checkNumberSize(numbers);
        checkNumberRange(numbers);
        checkNumberDuplicate(numbers);
    }

    // 게임이 끝난 후 입력받는 수가 1또는 2가 맞는지 검증하는 기능
    public static boolean checkProgramFinished(String programFinishNumber) {
        if (programFinishNumber.equals("1")) {
            return true;
        } else if (programFinishNumber.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1또는 2를 입력해 주세요.");
        }
    }

    // 유저의 숫자와 컴퓨터의 숫자를 비교하는 기능
    public static List<Integer> compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        List<Integer> result = new ArrayList<>(List.of(0, 0));
        boolean[] visited = new boolean[10];

        for (Integer computerNumber : computerNumbers) {
            visited[computerNumber] = true;
        }

        for (int i = 0; i < 3; i++) {
            Integer userNumber = userNumbers.get(i);
            Integer computerNumber = computerNumbers.get(i);

            if (computerNumber.equals(userNumber)) { // 스트라이크
                result.set(1, result.get(1)+1);
            } else if (visited[userNumber]) { // 볼
                result.set(0, result.get(0)+1);
            }
        }
        return result;
    }

    // 비교한 결과에 따라 볼, 스트라이크 개수를 출력하는 기능
    public static void printResult(List<Integer> result) {
        int ball = result.get(0);
        int strike = result.get(1);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0){
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}