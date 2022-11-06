package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// 출력 메시지 및 입력 관리
public class NumberBaseballGameClient {

    public static final String MSG_GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String MSG_ASK_PLAYER_GAME_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MSG_JUDGED_RESULT_BALLS = "볼";
    public static final String MSG_JUDGED_RESULT_STRIKES = "스트라이크";
    public static final String MSG_JUDGED_RESULT_NOTHING = "낫싱";
    public static final String MSG_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MSG_ASK_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String ANSWER_ONE_MORE_GAME = "1";
    public static final String ANSWER_NO_MORE_GAME = "2";

    private NumberBaseballGameClient() {
    }

    public static void showGameStartMessage() {
        System.out.println(MSG_GAME_START);
    }

    public static int askPlayerGameNumber() throws IllegalArgumentException {
        System.out.println(MSG_ASK_PLAYER_GAME_NUMBER);
        String line;
        try {
            line = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }

        int originalLength = line.length();
        line = line.strip();
        if (line.length() != 3 || line.length() != originalLength) {
            throw new IllegalArgumentException();
        }

        int playerGameNumber = Integer.parseInt(line);
        int tempNumber = playerGameNumber;

        int unit1 = tempNumber % 10;
        tempNumber /= 10;
        int unit100 = tempNumber / 10;
        int unit10 = tempNumber % 10;

        if (unit100 == unit10 || unit10 == unit1 || unit1 == unit100) {
            throw new IllegalArgumentException();
        }

        return playerGameNumber;
    }

    public static void showJudgedResult(NumberBaseballGameJudgedResultDto judgedResultDto) {
        int countStrikes = judgedResultDto.countStrikes;
        int countBalls = judgedResultDto.countBalls;

        if (countBalls == 0 && countStrikes == 0) {
            System.out.println(MSG_JUDGED_RESULT_NOTHING);
            return;
        }

        String resultMessage = "";
        if (countBalls != 0) {
            resultMessage += countBalls + MSG_JUDGED_RESULT_BALLS + " ";

        }
        if (countStrikes != 0) {
            resultMessage += countStrikes + MSG_JUDGED_RESULT_STRIKES;
        }

        System.out.println(resultMessage.strip());
    }

    public static void showGameEndMessage() {
        System.out.println(MSG_GAME_END);
    }

    public static boolean askMoreGame() throws IllegalArgumentException {
        System.out.println(MSG_ASK_MORE_GAME);
        String line;
        try {
            line = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }

        if (line.equals("1")) {
            return true;
        }
        if (line.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
