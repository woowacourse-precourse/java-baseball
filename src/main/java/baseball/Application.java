package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumberList = createComputerNumberList();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        List<Integer> userNumberList = validateUserNumber(userNumber);


    }

    public static List<Integer> validateUserNumber(String userNumbers) {
        List<String> numberList = stringToStringList(userNumbers);
        validateDigit(numberList);
        validateZero(numberList);
        validateSize(numberList);
        validateDuplication(numberList);

        return numberList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateZero(List<String> numberList) {
        if (numberList.contains("0")) {
            throw new IllegalArgumentException("UserNumber can't have Zero");
        }
    }

    private static void validateDigit(List<String> numberList) {
        for (String number : numberList) {
            isDigit(number);
        }
    }

    private static void isDigit(String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("UserNumber must be digit");
        }
    }


    private static void validateSize(List<String> numberList) {
        if (numberList.size() != 3) {
            throw new IllegalArgumentException("UserNumber must be three-digit number");
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
