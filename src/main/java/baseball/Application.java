package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Baseball {
    private static List<Integer> computerNumber;
    private static String userNumber;
    private static final int START_NUM_INCLUSIVE = 1;
    private static final int END_NUM_INCLUSIVE = 9;
    private static final int NUMBER_PITCH = 3;
    private static final int NEW_GAME = 1;
    private static final int END_GAME = 2;
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static void buildComputerNumber() {
        while (computerNumber.size() < NUMBER_PITCH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM_INCLUSIVE, END_NUM_INCLUSIVE);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private static void getUserNumber() {
        userNumber = Console.readLine();
        System.out.println(INPUT_NUMBER_MESSAGE + userNumber);
    }
}
