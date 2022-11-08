package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final int NUM_OF_DIGIT = 3;
    public static final int DIGIT_MIN = 1;
    public static final int DIGIT_MAX = 9;

    public static final int INPUT_NUM_MIN = 123;
    public static final int INPUT_NUM_MAX = 987;

    public static final int START_IDX = 0;
    public static final int END_IDX = 2;

    public static final int RESTART = 1;
    public static final int EXIT = 2;

    public static List<Integer> computerNumList = new ArrayList<>();
    public static List<Integer> userNumList = new ArrayList<>();
    public static int strikeCnt = 0;
    public static int ballCnt = 0;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            computerRandomThreeDigitNum();
            userInputThreeDigitNum();
            countStrikeAndBall();
            printBaseballResult();

            int inputCommand = 0;

            if (checkThreeStrike()) {
                inputCommand = userInputRestartOrFinish();
            }

            if (inputCommand == RESTART) {
                computerNumList = new ArrayList<>();
                userNumList = new ArrayList<>();
                continue;
            }

            if (inputCommand == EXIT) {
                break;
            }
        }
    }

    private static void computerRandomThreeDigitNum() {
        while (computerNumList.size() < NUM_OF_DIGIT) {
            int randomDigit = Randoms.pickNumberInRange(DIGIT_MIN, DIGIT_MAX);

            if (computerNumList.contains(randomDigit) == false) {
                computerNumList.add(randomDigit);
            }
        }
    }

    private static void userInputThreeDigitNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNum = Console.readLine();
        validateUserInputNumFormat(userInputNum);
        validateUserInputNumRange(userInputNum);

        userNumList = splitStringAndParseInt(userInputNum);
        validateUserNumListNoRepetition();
        validateUserNumListNotContainZero();
    }

    private static List<Integer> splitStringAndParseInt(String userInputNum) {
        List<Integer> ret = new ArrayList<>();
        String[] splitUserInputNum = userInputNum.split("");

        for (String s : splitUserInputNum) {
            ret.add(Integer.parseInt(s));
        }

        return ret;
    }

    private static void countStrikeAndBall() {
        strikeCnt = 0;
        ballCnt = 0;

        for (int computerIdx = START_IDX; computerIdx <= END_IDX; computerIdx++) {
            for (int userIdx = START_IDX; userIdx <= END_IDX; userIdx++) {
                increaseStrikeCntAndBallCnt(computerIdx, userIdx);
            }
        }
    }

    private static void increaseStrikeCntAndBallCnt(int computerIdx, int userIdx) {
        if (computerNumList.get(computerIdx) == userNumList.get(userIdx)) {
            if (computerIdx == userIdx) {
                strikeCnt++;
            }

            if (computerIdx != userIdx) {
                ballCnt++;
            }
        }
    }

    private static void printBaseballResult() {
        String result = "";

        if (ballCnt == 0 && strikeCnt == 0) {
            result = "낫싱";
        }

        if (ballCnt != 0) {
            result += ballCnt + "볼 ";
        }

        if (strikeCnt != 0) {
            result += strikeCnt + "스트라이크";
        }

        System.out.println(result);
    }

    private static boolean checkThreeStrike() {
        if (strikeCnt == NUM_OF_DIGIT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private static int userInputRestartOrFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInputCommand = Console.readLine();

        validateUserInputCommand(userInputCommand);
        return Integer.parseInt(userInputCommand);
    }

    private static void validateUserInputNumFormat(String userInputNum) {
        try {
            Integer.parseInt(userInputNum);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    private static void validateUserInputNumRange(String userInputNum) {
        int userInputNumToInt = Integer.parseInt(userInputNum);

        if (userInputNumToInt < INPUT_NUM_MIN || userInputNumToInt > INPUT_NUM_MAX) {
            throw new IllegalArgumentException("123 이상 987 이하의 숫자만 입력 가능합니다.");
        }
    }

    private static void validateUserNumListNoRepetition() {
        for (int idx = START_IDX; idx <= END_IDX; idx++) {
            int numAtIdx = userNumList.get(idx);
            List<Integer> userNumListAfterIdx = userNumList.subList(idx + 1, NUM_OF_DIGIT);

            if (userNumListAfterIdx.contains(numAtIdx)) {
                throw new IllegalArgumentException("같은 수를 중복해서 입력할 수 없습니다.");
            }
        }
    }

    private static void validateUserNumListNotContainZero() {
        if (userNumList.contains(0)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    private static void validateUserInputCommand(String userInputCommand) {
        try {
            Integer.parseInt(userInputCommand);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }

        int userInputCommandToInt = Integer.parseInt(userInputCommand);

        if (userInputCommandToInt != 1 && userInputCommandToInt != 2) {
            throw new IllegalArgumentException("숫자 1 혹은 2만 입력 가능합니다.");
        }
    }

}
