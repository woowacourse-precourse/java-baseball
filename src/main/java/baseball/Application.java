package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int SIZE = 3;
        int computer = CreateNumbers(SIZE);
        int input = InputNumbers(SIZE);
    }

    private static int CreateNumbers(int SizeOfNum) {
        List<Integer> computerIntList = new ArrayList<>();
        while (computerIntList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerIntList.contains(randomNumber)) {
               computerIntList.add(randomNumber);
            }
        }
        List<String> computerStrList = computerIntList.stream().map(Object::toString).collect(Collectors.toUnmodifiableList());
        int computer = Integer.parseInt(String.join("", computerStrList));
        return computer;
    }

    private static int InputNumbers(int SizeOfNum) throws IllegalArgumentException {
        String strInput = Console.readLine();
        if (strInput.length() != SizeOfNum) { // 1. 길이가 맞지 않는 값이 입력된 경우
            throw new IllegalArgumentException();
        }

        int intInput = Integer.parseInt(strInput);
        int[] arrInput = Stream.of(String.valueOf(intInput).split("")).mapToInt(Integer::parseInt).toArray();
        int[] check = new int[10];
        for (int i = 0; i < strInput.length(); i++) {
            if (check[arrInput[i]] == 1) { // 2. 각 자리수의 값이 중복이 있는 경우
                throw new IllegalArgumentException();
            }
            check[arrInput[i]] = 1;
        }

        return intInput;
    }
}
