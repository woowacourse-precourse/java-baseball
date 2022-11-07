package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameSimulation {
    private Computer computer;
    private int strike;
    private int ball;

    public GameSimulation() {
    }

    public void playGame() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        List<Integer> userNumber = makeList(userInput);
    }

    public List<Integer> makeList(String userInput) {
        String[] bitInput = userInput.split("");
        return Arrays
                .stream(bitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }
}
