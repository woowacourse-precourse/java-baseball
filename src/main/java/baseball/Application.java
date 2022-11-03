package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

class ConsolePrint {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumber() {
        System.out.print("\n숫자를 입력해주세요 : ");
    }

    public static void printBallMessage(int ballCount) {
        System.out.printf("%d볼 ", ballCount);
    }

    public static void printStrikeMessage(int strikeCount) {
        System.out.printf("%d스트라이크", strikeCount);
    }

    public static void printNothingMessage() {
        System.out.println("낫싱");
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printGameSelect() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

public class Application {

    private static boolean isGameOver(int strikeCount) {
        return strikeCount == 3;
    }

    private static int findStrike(int userNumber, int computerNumber) {
        if (userNumber == computerNumber) {
            return 1;
        }
        return 0;
    }

    private static int getStrikeCount(List<Integer> userNumber, List<Integer> computerNumber) {
        int strikeCount = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            strikeCount += findStrike(userNumber.get(index), computerNumber.get(index));
        }
        return strikeCount;
    }

    private static int getBallCount(List<Integer> userNumber, List<Integer> computerNumber) {
        int ballCount = 0;
        for (Integer computerElement : computerNumber) {
            ballCount += Collections.frequency(userNumber, computerElement);
        }
        return ballCount;
    }

    private static boolean isNothing(List<Integer> userNumber, List<Integer> computerNumber) {
        return Collections.disjoint(userNumber, computerNumber);
    }

    private static int getGameResult(List<Integer> userNumber, List<Integer> computerNumber) {
        int ballCount = getBallCount(userNumber, computerNumber);
        int strikeCount = getStrikeCount(userNumber, computerNumber);

        if (ballCount > 0 && strikeCount != ballCount) {
            ConsolePrint.printBallMessage(ballCount - strikeCount);
        }
        if (strikeCount > 0) {
            ConsolePrint.printStrikeMessage(strikeCount);
        }
        if (isNothing(userNumber, computerNumber)) {
            ConsolePrint.printNothingMessage();
        }
        return strikeCount;
    }

    private static int getGameSelect() {
        String gameSelect = Console.readLine();
        if (!gameSelect.equals("1") && !gameSelect.equals("2")) {
            ConsolePrint.printGameSelect();
            getGameSelect();
        }
        return Integer.parseInt(gameSelect);
    }

    private static int checkGameOver(int strikeCount) {
        int gameSelect = 0;
        if (isGameOver(strikeCount)) {
            ConsolePrint.printGameOver();
            ConsolePrint.printGameSelect();
            gameSelect = getGameSelect();
        }
        return gameSelect;
    }

    private static void startGameLogic() {
        int gameSelect = 0;
        List<Integer> computerNumber = Computer.getRandomNumber();
        ConsolePrint.printGameStart();
        do {
            ConsolePrint.printInputNumber();
            List<Integer> userNumber = User.getValidNumber();
            int strikeCount = getGameResult(userNumber, computerNumber);
            gameSelect = checkGameOver(strikeCount);
        } while(gameSelect != 2);
    }

    public static void main(String[] args) {
        startGameLogic();
    }
}
