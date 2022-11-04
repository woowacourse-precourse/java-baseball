package baseball.domain.view;

import baseball.domain.dto.ResultDto;
import java.util.Map;

public class OutputData {

    public static final String THREE_STRIKE_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private OutputData() {
    }

    public static void gameResultPrint(ResultDto resultDto) {
        Map<String, Integer> result = resultDto.getResult();
        for (String ballCount : result.keySet()) {
            checkBallCount(ballCount, result.get(ballCount));
        }
        System.out.println();
    }

    private static void checkBallCount(String ballCount, int count) {
        if (ballCount.equals("아웃")) {
            printOutCount(count);
            return;
        }
        if (ballCount.equals("볼")) {
            printBallCount(ballCount, count);
        }
        if (ballCount.equals("스트라이크")) {
            printStrikeCount(ballCount, count);
        }
    }

    private static void printOutCount(int count) {
        if (count == 3) {
            System.out.print("낫싱");
        }
    }

    private static void printBallCount(String ballCount, int count) {
        if (count != 0) {
            System.out.print(count + ballCount + " ");
        }
    }

    private static void printStrikeCount(String ballCount, int count) {
        if (count == 3) {
            System.out.println(count + ballCount);
            System.out.println(THREE_STRIKE_WIN_MESSAGE);
            return;
        }
        if (count != 0) {
            System.out.print(count + ballCount);
        }
    }
}
