package baseball;

import baseball.common.Constant;
import baseball.exception.NumberExceptionUtils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.common.Constant.MAX_STRIKE_SIZE;


public class GameUtils {

    private static List<Integer> answerNum;

    private static List<Integer> playerNum;

    public static void initBaseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        answerNum = getComputerAnswerNum();
    }

    public static void playBaseBallGame() {
        playerNum = getPlayerInputNum();
        int strike = checkStrikeAndUpdateScore(answerNum, playerNum);
        int ball = checkBallAndUpdateScore(answerNum, playerNum);
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
        while (answer.size() < MAX_STRIKE_SIZE) {
            int num = Randoms.pickNumberInRange(1, 9);
            answer.add(num);
        }
        return new ArrayList<>(answer);
    }

    public static int checkStrikeAndUpdateScore(List<Integer> answerNum, List<Integer> playerNum) {
        int strike = 0;
        for (int i = 0; i < Constant.MAX_STRIKE_SIZE; i++) {
            if (answerNum.get(i).equals(playerNum.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int checkBallAndUpdateScore(List<Integer> answerNum, List<Integer> playerNum) {
        int ball = 0;
        for (int i = 0; i < Constant.MAX_STRIKE_SIZE; i++) {
            if (!answerNum.get(i).equals(playerNum.get(i))
                    && answerNum.contains(playerNum.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
