package baseball;

import baseball.Util.Valid;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameSimulation {
    private Computer computer;
    private Integer strike;
    private Integer ball;
    private static final boolean INVALID = false;

    public void playGame() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNumber = makeList(userInput);
        validateUserNumber(userNumber);

        ball = computer.addBallScore(userNumber);
        strike = computer.addStrikeScore(userNumber);
    }

    public List<Integer> makeList(String userInput) {
        String[] bitInput = userInput.split("");
        List<Integer> userNumbers = Arrays
                .stream(bitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return userNumbers;
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
