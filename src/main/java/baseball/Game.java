package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

    List<Integer> computer;

    Game() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int inputUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void checkUserAnswerWhichIsCorrect(int userAnswer) {
        HashMap<String, Integer> StrikeAndBallCount = new HashMap<>();

        StrikeAndBallCount.put("Strike", 0);
        StrikeAndBallCount.put("Ball", 0);

        List<Integer> answer = List.of(userAnswer);


        for (int i = 0; i < 3; i++) {

        }
    }
    public void incorrectUserAnswerRule(int userAnswer) {
        int[] digits = intToList(userAnswer);
        System.out.println(digits.length);
        if (digits.length != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    public int[] intToList(int userAnswer) {
        return Stream.of(String.valueOf(userAnswer)
                .split("")).mapToInt(Integer::parseInt).toArray();
    }
}
