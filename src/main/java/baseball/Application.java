package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    private static final String EXCEPTION_TEXT = "INPUT MUST CONTAIN 3 DIFFERENT DIGITS ONLY";

    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    private static final String MESSAGE_STRIKE = "스트라이크";
    private static final String MESSAGE_BALL = "볼";
    private static final String MESSAGE_NOTHING = "낫싱";
    private static final String MESSAGE_START = "숫자 야구 게임을 시작합니다.";
    private static final String MESSAGE_THREE_STRIKES = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MESSAGE_RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String MESSAGE_INPUT = "숫자를 입력해주세요 : ";

    private static final String FLAG_RESTART = "1";
    private static final String FLAG_QUIT = "2";

    private static final int DIGIT_RESTRICTION = 3;

    private static String generateComputerNumber() { // computer의 세자릿수 생성
        List<String> digitList = new ArrayList<>();

        while (digitList.size() < 3) {
            int randomDigit = pickNumberInRange(1, 9);
            String digitStr = String.valueOf(randomDigit);

            if (!digitList.contains(digitStr)) {
                digitList.add(digitStr);
            }
        }

        String randomNumber = String.join("", digitList);
        return randomNumber;
    }
    public static void main(String[] args) {
        String computer = "";
        boolean iterate = true;
        int trial = 0;

        while (iterate) {
            if (trial == 0) {
                System.out.println(MESSAGE_START);
                computer = generateComputerNumber();
            }
        }
    }
}
