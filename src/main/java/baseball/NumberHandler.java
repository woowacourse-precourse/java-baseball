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

            numberDuplicateCheck(userNumberList);

            this.userNumber = userNumberList;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("공백없이 숫자만 입력해주세요.");
        }
    }

    public void numberDuplicateCheck(ArrayList<Integer> digits) {
        for (int digit : digits) {
            if (Collections.frequency(digits, digit) > 1) {
                throw new IllegalArgumentException("중복되는 숫자 없이 입력해주세요.");
            }
        }
    }
}
