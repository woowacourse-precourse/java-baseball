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
}