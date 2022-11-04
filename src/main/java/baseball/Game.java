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
    HashMap<String, Integer> strikeAndBallCount;

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
        strikeAndBallCount = new HashMap<>();

        strikeAndBallCount.put("Strike", 0);
        strikeAndBallCount.put("Ball", 0);

        checkAnswerState(strikeAndBallCount, stringToListInteger(userAnswer));
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

    public boolean printResultCompareWithAnswer(HashMap<String, Integer> strikeAndBallCount) {
        Integer strike = strikeAndBallCount.get("Strike");
        Integer ball = strikeAndBallCount.get("Ball");

        if (strike == 0 && ball != 0) {
            System.out.println(strikeAndBallCount.get("Strike") + "스트라이크");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strikeAndBallCount.get("Ball") + "볼");
        } else if (strike != 0 && ball != 0) {
            System.out.println(strikeAndBallCount.get("Ball") + "볼 "
                    + strikeAndBallCount.get("Strike") + "스트라이크");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.print("3스트라이크" +"\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }
}

/** 숫자를 입력해주세요 : 123
        * 1볼 1스트라이크
        * 숫자를 입력해주세요 : 145
        * 1볼
        * 숫자를 입력해주세요 : 671
        * 2볼
        * 숫자를 입력해주세요 : 216
        * 1스트라이크
        * 숫자를 입력해주세요 : 713
        * 3스트라이크
 */
