package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public String inputUserAnswer() {
        return Console.readLine();
    }

    public void checkUserAnswerWhichIsCorrect(String userAnswer) {
        HashMap<String, Integer> strikeAndBallCount = new HashMap<>();

        strikeAndBallCount.put("Strike", 0);
        strikeAndBallCount.put("Ball", 0);

        List<Integer> answer = stringToListInteger(userAnswer);

        checkAnswerState(strikeAndBallCount, answer);
    }

    private void checkAnswerState(HashMap<String, Integer> strikeAndBallCount, List<Integer> userAnswer) {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(userAnswer.get(i))
                    && (userAnswer.get(i).equals(computer.get(i)))) {
                strikeAndBallCount.put("Strike", strikeAndBallCount.get("Strike") + 1);
            } else if (computer.contains(userAnswer.get(i))
                    && (!userAnswer.get(i).equals(computer.get(i))))
            strikeAndBallCount.put("Ball", strikeAndBallCount.get("Ball") + 1);
        }
    }

    public void incorrectUserAnswerRule(String userAnswer) {
        List<Integer> answerList = stringToListInteger(userAnswer);
        if (answerList.size() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    private List<Integer> stringToListInteger(String userAnswer) {
        return listToListInteger(List.of(userAnswer.split("")));
    }

    private List<Integer> listToListInteger(List<String> answerList) {
        return answerList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
