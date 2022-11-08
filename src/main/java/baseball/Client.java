package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// 출력 메시지 및 입력 관리
public class Client {

    public static final String MSG_GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String MSG_ASK_PLAYER_GAME_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MSG_JUDGED_RESULT_BALLS = "볼";
    public static final String MSG_JUDGED_RESULT_STRIKES = "스트라이크";
    public static final String MSG_JUDGED_RESULT_NOTHING = "낫싱";
    public static final String MSG_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MSG_ASK_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String ANSWER_ONE_MORE_GAME = "1";
    public static final String ANSWER_NO_MORE_GAME = "2";

    private Client() {
    }

    public static void showGameStartMessage() {
        System.out.println(MSG_GAME_START);
    }

    public static List<Integer> askPlayerNumberList() throws IllegalArgumentException {
        System.out.print(MSG_ASK_PLAYER_GAME_NUMBER);

        String line;
        try {
            line = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }

        if (line.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> playerNumberList = new ArrayList<>();

        for (String substring : line.split("")) {
            int degreeNumber = Integer.parseInt(substring);
            if (degreeNumber == 0 || playerNumberList.contains(degreeNumber)) {
                throw new IllegalArgumentException();
            }
            playerNumberList.add(degreeNumber);
        }

        return playerNumberList;
    }

    public static void showJudgedResult(JudgedResultDto dto) {
        int countStrikes = dto.getCountStrikes();
        int countBalls = dto.getCountBalls();

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
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (line.equals(ANSWER_ONE_MORE_GAME)) {
            return true;
        }
        if (line.equals(ANSWER_NO_MORE_GAME)) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
