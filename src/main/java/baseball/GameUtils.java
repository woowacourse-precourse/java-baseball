package baseball;

import baseball.exception.NumberExceptionUtils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.common.Constant.DIGIT_LENGTH_LIMIT;


public class GameUtils {

    private static int strike;

    private static int ball;

    private static List<Integer> answerNum;

    private static List<Integer> playerNum;

    public static void initBaseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        answerNum = getComputerAnswerNum();
    }

    public static void playBaseBallGame() {
        strike = 0;
        ball = 0;
        playerNum = getPlayerInputNum();
        compareInputAndAnswer();
    }

    public static List<Integer> getPlayerInputNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        checkValidInput(input);
        return mapStringToIntegerList(input);
    }

    private static List<Integer> mapStringToIntegerList(String input) {
        return Stream.of(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static void checkValidInput(String input) {
        NumberExceptionUtils.isPositiveDigits(input);
        NumberExceptionUtils.isThreeDigits(input);
        NumberExceptionUtils.isNotDuplicateNumber(input);
    }

    public static List<Integer> getComputerAnswerNum() {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < DIGIT_LENGTH_LIMIT) {
            int num = Randoms.pickNumberInRange(1, 9);
            answer.add(num);
        }
        return new ArrayList<>(answer);
    }

    public static void compareInputAndAnswer() {
        for (int i = 0; i < answerNum.size(); i++) {
            for (int j = 0; j < playerNum.size(); j++) {
                checkStrikeAndUpdateScore(i, j);
                checkBallAndUpdateScore(i, j);
            }
        }
    }

    private static void checkStrikeAndUpdateScore(int i, int j) {
        if (i == j && answerNum.get(i).equals(playerNum.get(j))) {
            strike++;
        }
    }

    private static void checkBallAndUpdateScore(int i, int j) {
        if (i != j && answerNum.get(i).equals(playerNum.get(j))) {
            ball++;
        }
    }
}
