package baseball.processor;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameInitProcessorImpl implements GameInitProcessor {

    @Override
    public List<Integer> randomNumber(Integer size) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    @Override
    public List<Integer> userInput() {
        try {
            return Arrays.stream(callInputString().split(""))
                    .map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private String callInputString() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
