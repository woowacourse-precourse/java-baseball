package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberHandler {

    private final ArrayList<Integer> computerNumber;
    private ArrayList<Integer> userNumber;

    public NumberHandler() {
        ArrayList<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        computerNumber = computer;
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    public ArrayList<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber() {
        String userInput = Console.readLine();

        try {
            int[] userNumberArray = Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();

            ArrayList<Integer> userNumberList = (ArrayList<Integer>) Arrays.stream(userNumberArray)
                    .boxed()
                    .collect(Collectors.toList());

            numberDuplicateAndZeroCheck(userNumberList);
            numberLengthCheck(userNumberList);

            this.userNumber = userNumberList;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("공백없이 숫자만 입력해주세요.");
        }
    }

    public void numberDuplicateAndZeroCheck(ArrayList<Integer> digits) {
        for (int digit : digits) {
            if (Collections.frequency(digits, digit) > 1) {
                throw new IllegalArgumentException("중복되는 숫자 없이 입력해주세요.");
            }

            if (digit == 0) {
                throw new IllegalArgumentException("입력 가능한 숫자 범위는 1 ~ 9 입니다.");
            }
        }
    }

    public void numberLengthCheck(ArrayList<Integer> digits) {
        if (digits.size() != 3) {
            throw new IllegalArgumentException("숫자 3개만 입력해주세요.");
        }
    }

}
