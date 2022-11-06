package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    List<Integer> computer;

    public Game() {
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
                strikeAndBallCount.put("Strike", strikeAndBallCount.get("Strike") + 1);
            } else if (computer.contains(userAnswer.get(i))
                    && (!userAnswer.get(i).equals(computer.get(i)))) {
                strikeAndBallCount.put("Ball", strikeAndBallCount.get("Ball") + 1);
            }
        }
        return strikeAndBallCount;
    }

    public void checkExceptions(String userAnswer) {
        incorrectUserAnswerNonNaturalNum(userAnswer);
        incorrectUserAnswerDigit(userAnswer);
        incorrectUserAnswerDuplicate(userAnswer);
    }

    private void incorrectUserAnswerDigit(String userAnswer) {
        List<Integer> answerList = stringToListInteger(userAnswer);
        if (answerList.size() != 3) {
            throw new IllegalArgumentException("입력 값은 3자리 수로 입력하십시오.");
        }
    }

    private void incorrectUserAnswerDuplicate(String userAnswer) {
        HashSet<Character> answerList = new HashSet<Character>();
        for (int i = 0; i < userAnswer.length(); i++) {
            answerList.add(userAnswer.charAt(i));
        } if (answerList.size() != 3) {
            throw new IllegalArgumentException("입력 값은 서로 다른 숫자이어야 합니다.");
        }
    }

    private void incorrectUserAnswerNonNaturalNum(String userAnswer) {
        if (!userAnswer.matches("[+-]?\\d*(\\.\\d+)?") || userAnswer.contains("0")) {
            throw new IllegalArgumentException("입력 값은 1 ~ 9 숫자이어야 합니다.");
        }
    }

    public List<Integer> stringToListInteger(String userAnswer) {
        return Arrays.stream(userAnswer.split(""))
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
            System.out.println("3스트라이크" + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    public String replayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
