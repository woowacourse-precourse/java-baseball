package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Game {

    private List<Integer> computer;
    private final String startComment = "숫자 야구 게임을 시작합니다.";
    private final String inputComment = "숫자를 입력해주세요 : ";

    private List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private List<Integer> input() {
        List<Integer> inputNumber = new ArrayList<>();
        String input = Console.readLine();

        for (int i = 0; i < input.length(); i++) {
            inputNumber.add(Character.getNumericValue(input.charAt(i)));
        }

        return inputNumber;
    }

    public Game() {
        this.computer = makeRandomNumber();
    }

    public List<Integer> getComputer() {
        return computer;
    }
}
