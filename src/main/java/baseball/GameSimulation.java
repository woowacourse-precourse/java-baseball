package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameSimulation {
    private Computer computer;
    private Integer strike;
    private Integer ball;

    public void playGame() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNumber = makeList(userInput);
    }

    public List<Integer> makeList(String userInput) {
        String[] bitInput = userInput.split("");
        List<Integer> userNumbers = Arrays
                .stream(bitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return userNumbers;
    }
}
