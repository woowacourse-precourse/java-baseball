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

    public boolean checkUserAnswerWhichIsCorrect(String userAnswer) {
        HashMap<String, Integer> strikeAndBallCount = new HashMap<>();

        strikeAndBallCount.put("Strike", 0);
        strikeAndBallCount.put("Ball", 0);

        HashMap<String, Integer> strikeAndBallCountResult = checkAnswerState(strikeAndBallCount, stringToListInteger(userAnswer));

        return printResultCompareWithAnswer(strikeAndBallCountResult);
    }

    private HashMap<String, Integer> checkAnswerState(HashMap<String, Integer> strikeAndBallCount, List<Integer> userAnswer) {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(userAnswer.get(i))
                    && (userAnswer.get(i).equals(computer.get(i)))) {
                System.out.println("스트라이크 " + userAnswer.get(i) + " " + computer.get(i));
                strikeAndBallCount.put("Strike", strikeAndBallCount.get("Strike") + 1);
            } else if (computer.contains(userAnswer.get(i))
                    && (!userAnswer.get(i).equals(computer.get(i)))) {
                strikeAndBallCount.put("Ball", strikeAndBallCount.get("Ball") + 1);
            }
        }
        return strikeAndBallCount;
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

    private boolean printResultCompareWithAnswer(HashMap<String, Integer> strikeAndBallCount) {
        Integer strike = strikeAndBallCount.get("Strike");
        Integer ball = strikeAndBallCount.get("Ball");

        if (strike == 0 && ball != 0) {
            System.out.println(strikeAndBallCount.get("Ball") + "볼");
        } else if (strike != 3 && strike != 0 && ball == 0) {
            System.out.println(strikeAndBallCount.get("Strike") + "스트라이크");
        } else if (strike != 0 && ball != 0) {
            System.out.println(strikeAndBallCount.get("Ball") + "볼 "
                    + strikeAndBallCount.get("Strike") + "스트라이크");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
//            System.out.println(strikeAndBallCount);
            System.out.print("3스트라이크" + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");


            return true;
        }

        return false;
    }

    private String replayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
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
