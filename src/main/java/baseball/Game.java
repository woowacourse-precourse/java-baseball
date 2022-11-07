package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Game {

    private List<Integer> computer;
    private List<Integer> inputNumber;

    // 스트라이크 , 볼
    private List<Integer> count;

    private final String startComment = "숫자 야구 게임을 시작합니다.";
    private final String inputComment = "숫자를 입력해주세요 : ";

    // 랜덤 넘버 생성 기능
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

    // 사용자 입력 저장 기능
    private List<Integer> input() {
        List<Integer> inputNumber = new ArrayList<>();
        String input = Console.readLine();

        for (int i = 0; i < input.length(); i++) {
            inputNumber.add(Character.getNumericValue(input.charAt(i)));
        }

        return inputNumber;
    }

    // 입력에 대한 결과 기능
    private void checkInput() {
        count = new ArrayList<>();
        count.add(0);
        count.add(0);
        for (int i = 0; i < inputNumber.size(); i++) {
            for (int j = 0; j < computer.size(); j++) {
                strikeOrBall(i, j);
            }
        }
    }

    private void strikeOrBall(int i, int j) {
        if (i == j) {
            count.set(0, count.get(0) + 1);
        } else {
            count.set(1, count.get(1) + 1);
        }
    }

    public Game() {
        // 랜덤 넘버 생성
        this.computer = makeRandomNumber();

        // 사용자 입력 받기
        this.inputNumber = input();
    }

    public List<Integer> getComputer() {
        return computer;
    }

    public List<Integer> getInputNumber() {
        return inputNumber;
    }
}
