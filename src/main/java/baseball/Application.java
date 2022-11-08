package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumberList = createComputerNumberList();
        System.out.println("숫자 야구 게임을 시작합니다.");

        String restartNumber;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = Console.readLine();
            List<Integer> userNumberList = validateUserNumber(userNumber);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartNumber = Console.readLine();
            validateRestartNumber(restartNumber);
        } while (restartNumber.equals("1"));
    }

    public static void validateRestartNumber(String restartNumber) {
        List<String> restartList = stringToStringList(restartNumber);
        validateDigit(restartNumber);
        validateSize(restartNumber, 1);
        validateRange(restartNumber, "^[1-2]*$");
    }

    public static List<Integer> validateUserNumber(String userNumbers) {
        List<String> numberList = stringToStringList(userNumbers);
        validateDigit(userNumbers);
        validateSize(userNumbers, 3);
        validateRange(userNumbers, "^[1-9]*$");
        validateDuplication(numberList);

        return numberList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateRange(String numbers, String regex) {

        if (!Pattern.matches(regex, numbers)) {
            throw new IllegalArgumentException("Number is out of range");
        }
    }

    private static void validateDigit(String numbers) {
        for (char number : numbers.toCharArray()) {
            checkDigit(number);
        }
    }

    private static void checkDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException("Number must be digit");
        }
    }


    private static void validateSize(String numbers, int digitSize) {
        if (numbers.length() != digitSize) {
            throw new IllegalArgumentException("Number must be correct-digit size: " + digitSize);
        }
    }

    private static void validateDuplication(List<String> numberList) {
        HashMap<String, Integer> checkMap = new HashMap<>();

        for (String number : numberList) {
            checkMap.put(number, checkMap.getOrDefault(number, 0) + 1);
        }

        if (checkMap.containsValue(2) || checkMap.containsValue(3)) {
            throw new IllegalArgumentException("UserNumber has duplicate number");
        }
    }

    private static List<String> stringToStringList(String numbers) {
        String[] arr = numbers.split("");
        return Arrays.asList(arr);
    }

    public static List<Integer> createComputerNumberList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }
}
