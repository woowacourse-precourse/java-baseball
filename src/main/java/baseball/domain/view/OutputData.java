package baseball.domain.view;

import baseball.domain.dto.ResultDto;
import java.util.Map;

public class OutputData {

    public static final String THREE_STRIKE_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static String output = "";

    private OutputData() {
    }


    public static void gameResultPrint(ResultDto resultDto) {
        Map<String, Integer> result = resultDto.getResult();
        for (String ballCount : result.keySet()) {
            checkBallCount(ballCount, result.get(ballCount));
        }
        printOutput();
    }

    private static void printOutput() {
        System.out.print(output);
        System.out.println();
        output = "";
    }

    private static void checkBallCount(String ballCount, int count) {
        if (ballCount.equals("아웃")) {
            output += printOutCount(count);
        }
        if (ballCount.equals("볼")) {
            output += printBallCount(ballCount, count);
        }
        if (ballCount.equals("스트라이크")) {
            output += printStrikeCount(ballCount, count);
        }
    }

    private static String printOutCount(int count) {
        if (count == 3) {
            return "낫싱";
        }
        return "";
    }

    private static String printBallCount(String ballCount, int count) {
        if (count != 0) {
            return count + ballCount;
        }
        return "";
    }

    private static String printStrikeCount(String ballCount, int count) {
        if (count == 3) {
            return count + ballCount + "\n" + THREE_STRIKE_WIN_MESSAGE;
        }
        if (count != 0) {
            return checkJustStrike(ballCount, count);
        }
        return "";
    }

    private static String checkJustStrike(String ballCount, int count) {
        if (output.equals("")) {
            return count + ballCount;
        }
        return " " + count + ballCount;
    }
}
