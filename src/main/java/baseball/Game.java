package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
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
        HashMap<String, Integer> strikeAndBallCount = new HashMap<>();

        strikeAndBallCount.put("Strike", 0);
        strikeAndBallCount.put("Ball", 0);

        int[] answer = intToList(userAnswer);

        checkAnswerState(strikeAndBallCount, answer);
    }

    private void checkAnswerState(HashMap<String, Integer> strikeAndBallCount, int[] answer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer[i] == computer.get(j) && i == j) {
                    strikeAndBallCount.put("Strike", strikeAndBallCount.get("Strike") + 1);
                    break;
                } else if (answer[i] == computer.get(j) && i != j) {
                    strikeAndBallCount.put("Ball", strikeAndBallCount.get("Ball") + 1);
                    break;
                }
            }
        }
    }

    public void incorrectUserAnswerRule(int userAnswer) {
        int[] answer = intToList(userAnswer);
        if (answer.length != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    private int[] intToList(int userAnswer) {
        return Stream.of(String.valueOf(userAnswer)
                .split("")).mapToInt(Integer::parseInt).toArray();
    }
}
