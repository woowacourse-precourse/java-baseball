package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameSimulation {
    private Computer computer;
    private int strike;
    private int ball;
    private static final boolean INVALID = false;

    public GameSimulation() {
    }

    public void playGame() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        List<Integer> userNumber = makeList(userInput);
        validateUserNumber(userNumber);

        ball = computer.addBallScore(userNumber);
        strike = computer.addStrikeScore(userNumber);
    }

    public List<Integer> makeList(String userInput) {
        String[] bitInput = userInput.split("");
        return Arrays
                .stream(bitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public void validateUserNumber(List<Integer> userNumber) {
        try {
            if (Valid.validNumberList(userNumber) == INVALID) {
                throw new IllegalArgumentException("올바른 숫자가 아닙니다. 다시 입력해주세요.");
            }
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
